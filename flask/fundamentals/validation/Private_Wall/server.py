from flask_app import app
from flask_app.controllers import comment_controller,login_reg_controller,post_controller,user_controller




if __name__=="__main__":
    app.run(debug=True,port=5001)