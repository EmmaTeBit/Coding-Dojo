from flask_app.config.mysqlconnection import connectToMySQL
from flask_app.models import burger,topping

class Restaurant:
    def __init__(self,data):
        self.id = data['id']
        self.name = data['name']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        
        self.burger=[]
        
    @classmethod
    def show_burgers_made(cls,data):
        query = "SELECT * FROM burgers LEFT JOIN add_ons ON add_ons.burger_id = burgers.id LEFT JOIN toppings ON add_ons.topping_id = toppings.id WHERE burgers.id = %(id)s;"
        results = connectToMySQL('burgers').query_db( query , data )
        # results will be a list of topping objects with the burger attached to each row. 
        burger = cls( results[0] )
        for row_from_db in results:
            # Now we parse the topping data to make instances of toppings and add them into our list.
            burger_data = {
                "id" : row_from_db["burgers.id"],
                "name" : row_from_db["name"],
                "bun" : row_from_db["bun"],
                "calories" : row_from_db["calories"],
                "created_at" : row_from_db["toppings.created_at"],
                "updated_at" : row_from_db["toppings.updated_at"]
            }  # This is where the topping class is dependent on the Burger class
        return burger
    
    # bugers and topping- get byurgers with topping -bring in query: burger.pyline 20
    # if wanted to see restaurent - give call methods dif var names
    # burger= burger.gert topping_data
    # rest = rest.show burger made data
    # ginja -access burger and Restaurant.into html