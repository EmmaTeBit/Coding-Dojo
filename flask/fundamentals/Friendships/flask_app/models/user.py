from flask_app.config.mysqlconnection import connectToMySQL

class User:
    def __init__(self,data):
        self.id = data ['id']
        self.first_name = data ['first_name']
        self.last_name = data ['last_name']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.friend = None
        # None stores an empty obj
    

    @classmethod
    # data=is a dictionary that has 2 kewys "fname and lname"
    def save(cls,data):
        query = "INSERT INTO users (first_name, last_name) VALUES (%(first_name)s,%(last_name)s);"
        return connectToMySQL('friendships').query_db(query,data)

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM users;"
        users = []
        results = connectToMySQL('friendships').query_db(query)
        for row in results:
            users.append(cls(row))
        return users

    @classmethod
    def join_friendship(cls):
        query = "SELECT * FROM friendships JOIN users ON users.id = user_id JOIN users AS friend ON friend.id = friend_id;"
        # -- we renamed users AS friend so = friend.it instead"
        results = connectToMySQL('friendships').query_db(query,data)
        friendship = []
        for row in results:
            if row['friend.id'] == None:
                break
            data = {
                'id': row['users.id']
            }
            friendship.append(cls(row))
        return friendship

    @classmethod
    def display_relationships(cls):
        query = """
        SELECT users.first_name, users.last_name, users2.first_name AS 
        friend_first_name, users2.last_name AS friend_last_name FROM users
        JOIN friendships ON users.id = friendships.user_id
        LEFT JOIN users AS users2 ON users2.id = friendships.friend_id;
        """
        results = connectToMySQL('friendships').query_db(query)
        print("B")
        print(results)
        return results
    #send obj instead of results for next time-so create a class for friendship-
    #===================Joining Friends together============#
    @classmethod
    def not_friends(cls):
        query = "SELECT * FROM users WHERE users.id NOT IN ( SELECT user_id FROM friendships WHERE user_id = %(id)s );"
        friendships = []
        results = connectToMySQL('friendships').query_db(query)
        for row in results:
            friendships.append(cls(row))
        return friendships
    
    @classmethod
    def add_friends(cls,data):
        query = "INSERT INTO friendships (user_id,friend_id) VALUES (%(user_id)s,%(friend_id)s);"
        return connectToMySQL('friendships').query_db(query,data);
    
    @classmethod
    def get_by_id(cls,data):
        query = "SELECT * FROM users LEFT JOIN friendships ON users.id = friendships.user_id LEFT JOIN friendships ON friend.id = friendships.friend_id WHERE users.id = %(id)s;"
        results = connectToMySQL('friendships').query_db(query,data)

        new_friend = cls(results[0])
        for row in results:
            # if there are no favorites
            if row['friend.id'] == None:
                break
            data = {
                "id": row['friend.id'],
                "first_name": row['first_name'],
                "last_name": row['last_name'],
                "created_at": row['friend.created_at'],
                "updated_at": row['friend.updated_at']
            }
            new_friend.friendships_users.append(user.User(data))
        return new_friend