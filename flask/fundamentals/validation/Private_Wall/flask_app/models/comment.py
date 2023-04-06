from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash

DB = "public_dojo_wall"
class Comment:
    def __init__(self,data):
        self.id = data['id']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.content = data['content']
        self.user_id = data['user_id']
        self.post_id = data['post_id']
        

#================Validate Comment Creation===================#
    @staticmethod
    def validate_create(request):
        is_valid = True
        if len(request['content']) < 1:
            flash('Cannot Be Blank')
            is_valid = False
        return is_valid
#================Saving The Comment ===================#
    @classmethod
    def save(cls,data):
        query = """
        INSERT INTO comments 
        (content,user_id, post_id) 
        VALUES 
        (%(content)s,%(user_id)s,%(post_id)s;
        """
        results = connectToMySQL(DB).query_db(query,data)
        return results
    #===============DESTROY===================#
    @classmethod
    def delete_by_id(cls,data):
        query = """
        DELETE FROM comments 
        WHERE id = %(id)s
        """
        results = connectToMySQL(cls.DB).query_db(query,data)