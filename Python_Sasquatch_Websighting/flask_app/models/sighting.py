from flask_app import app
from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash
from flask_bcrypt import Bcrypt
from flask_app.models import user
import re
#================================================================
DB = "Sasquatch"

class Sighting:
    def __init__(self,sighting):
        self.id = sighting['id']
        self.location = sighting['location']
        self.description = sighting['description']
        self.date_of_sighting = sighting['date_of_sighting']
        self.num_of_sasquatch = sighting['num_of_sasquatch']
        self.created_at = sighting['created_at']
        self.updated_at = sighting['updated_at']
        self.user = None
#============================SAVE====================================
    @classmethod
    def create_valid_sighting(cls,sighting_dict):
        if not cls.is_valid(sighting_dict):
            return False
        query = '''
        INSERT INTO sightings 
        (location, description, date_of_sighting, num_of_sasquatch, user_id) 
        VALUES 
        (%(location)s,%(description)s,%(date_of_sighting)s,
        %(num_of_sasquatch)s,%(user_id)s);
        '''
        sighting_id = connectToMySQL(DB).query_db(query, sighting_dict)
        sighting = cls.get_by_id(sighting_id)
        return sighting
#================================================================
    @classmethod
    def get_by_id(cls, sighting_id):
        data = {"id": sighting_id}
        query = """
        SELECT sightings.id, sightings.created_at, sightings.updated_at, location, description, date_of_sighting, num_of_sasquatch,
        users.id as user_id, first_name, last_name, email, users.created_at as uc, users.updated_at as uu
        FROM sightings
        JOIN users on users.id = sightings.user_id
        WHERE sightings.id = %(id)s;
        """
        result = connectToMySQL(DB).query_db(query,data)
        result = result[0]
        sighting = cls(result)
        sighting.user = user.User(
                {
                    "id": result["user_id"],
                    "first_name": result["first_name"],
                    "last_name": result["last_name"],
                    "email": result["email"],
                    "created_at": result["uc"],
                    "updated_at": result["uu"]
                }
            )
        return sighting
#=============ACTIONS======================
    @classmethod
    def delete_sighting_by_id(cls,sighting_id):
        data = {"id": sighting_id}
        query = "DELETE FROM sightings WHERE id = %(id)s;"
        connectToMySQL(DB).query_db(query,data)
        return sighting_id
    
#=============ACTIONS======================
    @classmethod
    def update_sighting(cls, sighting_dict, session_id):
        sighting = cls.get_by_id(sighting_id['id'])
        if sighting.user.id != session_id:
            flash("You must be the creator to edit this report")
            return False
        if not cls.is_valid(sighting_dict):
            return False
        query = '''
        UPDATE sightings 
        SET location=%(location)s, 
        description=%(description)s, 
        date_of_sighting=%(date_of_sighting)s, 
        num_of_sasquatch=%(num_of_sasquatch)s, 
        updated_at=NOW() 
        WHERE id = %(id)s;
        '''
        result = connectToMySQL(DB).query_db(query,sighting_dict)
        sighting = cls.get_by_id(sighting_id['id'])
        
        return sighting
#================================================================
    @classmethod
    def get_all(cls):
        query = """
        SELECT 
        sightings.id, 
        sightings.created_at, 
        sightings.updated_at, 
        location,
        description,
        date_of_sighting,
        num_of_sasquatch,
        users.id as user_id, first_name, last_name, email, users.created_at as uc,
        users.updated_at as uu
        FROM sightings
        JOIN users on users.id = sightings.user_id;
        """
        sighting_data = connectToMySQL(DB).query_db(query)
        sightings = []

        for sighting in sighting_data:
            sighting_obj = cls(sighting)
            sighting_obj.user = user.User(
                {
                    'id':sighting['users.id'],
                    'first_name':sighting['first_name'],
                    'last_name':sighting['last_name'],
                    'email':sighting['email'],
                    'password':sighting['password'],
                    'created_at':sighting['uc'],
                    'updated_at':sighting['uu']
                }
            )
            sighting.append(sighting_obj)
        return sightings
#=============validate_sighting======================
    @staticmethod
    def is_valid(sighting_dict):
        valid = True
        flash_string = "All field required"
        if len(sighting_dict['location']) < 2:
            valid = False
            flash("Location must be at least 2 character","sighting")
        if len(sighting_dict['description']) < 3:
            valid = False
            flash("Description must be at least 3 characters","sighting")
        if sighting_dict['date_of_sighting'] == "":
            valid = False
            flash("Please enter a date","sighting")
        if int(sighting_dict['num_of_sasquatch']) < 1:
            flash("Number of Sasquatch must be atleast 1","sighting")
            valid = False
        return valid