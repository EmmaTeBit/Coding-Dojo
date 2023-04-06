from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash
from flask_app.models import comment

DB = "public_dojo_wall"
class Post:
    def __init__(self,data):
        self.id = data['id']
        self.content = data['content']
        self.user_id = data['user_id']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.creator = None
        self.comment = []
#================Validate Post Creation===================#
    @staticmethod
    def validate_create(request):
        is_valid = True
        if len(request['content']) < 1:
            flash('Cannot Be Blank')
            is_valid = False
        return is_valid
#================Saving The Community post===================#
    @classmethod
    def save(cls,data):
        query = """
        INSERT INTO posts 
        (content,user_id) 
        VALUES 
        (%(content)s,%(user_id)s);
        """
        results = connectToMySQL(DB).query_db(query,data)
        return results
#================SHOW GET ALL ==================#
    @classmethod
    def get_all(cls):
        query = """
        SELECT post.*, users.first_name AS username
        FROM posts
        JOIN users
        ON post.user_id = users.id;
        """
        results = connectToMySQL(DB).query_db(query)
        output = []
        for row in results:
            this_post = cls(row)
            this_post.creator = row['username']
            post_dict = {
                'post_id':row['id']
            }
            query2 = """
            SELECT * FROM comments
            WHERE post_id = %(post_id)s;
            """
            results2 = connectToMySQL(DB).query_db(query2, post_dict)
            for comm in results2:
                this_post.comments.append(comment.Comment(comm))
                
            output.append(this_post)
        return output
#===============DESTROY===================#
    @classmethod
    def delete_by_id(cls,data):
        query = """
        DELETE FROM posts 
        WHERE id = %(id)s;
        """
        results = connectToMySQL(DB).query_db(query,data)