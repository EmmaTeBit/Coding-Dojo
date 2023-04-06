from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash
import re
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$') 
#=============================================#
DB = "public_dojo_wall"

class User:
    def __init__(self,data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.password = data['password']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
#================VALIDATION: Registry==============#
    @staticmethod
    def validate_register(request):
        is_valid = True
        if len(request['first_name']) < 1:
            flash("Please enter a First Name","regError")
            is_valid= False
        elif len(request['first_name']) < 2:
            flash("First Name must be longer than two characters","regError")
            is_valid= False
        if len(request['last_name']) < 1:
            flash("Please enter a Last Name","regError")
            is_valid= False
        elif len(request['last_name']) < 2:
            flash("Last Name must be longer than two characters","regError")
            is_valid= False
        if len(request[email]) < 1:
            flash("Please Enter an Email Address","regError")
            is_valid=False
        elif not EMAIL_REGEX.match(request['email']):
            flash("Invalid Email Address!","regError")
            is_valid=False
        if len(request['password']) < 1:
            flash("Please Enter a password","regError")
            is_valid= False
        elif request['password'] != request['passConf']:
            flash("Passwords does NOT match","regError")
            is_valid= False
        if  User.get_by_email(request) != False:
            flash("Email already taken","regError")
            is_valid= False
        return is_valid
            
#================SAVE===================#
    @classmethod
    def save(cls, data):
        query = """
        INSERT into users 
        (first_name, last_name, email,password) 
        VALUES 
        (%(first_name)s, %(last_name)s, %(email)s,%(password)s);
        """
        results = connectToMySQL(DB).query_db(query, data)
        return results
#===============GET ALL ==================#
    @classmethod
    def get_all(cls):
        query = """
        SELECT * FROM users;
        """
        results = connectToMySQL(DB).query_db(query)
        output = []
        for row in results:
            users.append( cls(row) )
        return output
#================DELETE by ID====================#
    @classmethod
    def delete_by_id(cls,data):
        query = """
        DELETE * FROM users WHERE id = %(id)s;
        """
        results = connectToMySQL(DB).query_db(query,data)
#================GET by ID====================#
    @classmethod
    def get_by_id(cls,data):
        query = """
        SELECT * FROM users WHERE id = %(id)s;
        """
        results = connectToMySQL(DB).query_db(query,data)
        if len(results) < 1:
            return False
        return cls(results[0])

#================GET by EMAIL====================#
    @classmethod
    def get_by_email(cls,data):
        query = """
        SELECT * FROM users WHERE email = %(email)s;
        """
        results = connectToMySQL(DB).query_db(query,data)
        if len(results) < 1:
            return False
        return cls(results[0])