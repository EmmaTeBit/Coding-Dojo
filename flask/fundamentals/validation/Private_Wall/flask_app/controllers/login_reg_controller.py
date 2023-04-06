from flask_app import app
from flask import render_template,redirect,request,session,flash
#================MODEL imoport===================#
from flask_app.models.user import User
#================Bcrypt===================#
from flask_bcrypt import Bcrypt
bcrypt = Bcrypt(app)
from datetime import datetime
dateFormat = '%m/%d/%Y %I:%M %p'
#================Home===================#
@app.route("/")
def index():
    return render_template("index.html")
#================Registry===================#
@app.route('/register', methods=["POST"])
def register():
    #validate user input
    if user.User.validate_register(request.form):
        #secure pw via Bcrypt
        pw_hash = bcrypt.generate_password_hash(request.form['password'])
        #if valid-save to DB
        data = {
            'first_name': request.form['first_name'],
            'last_name': request.form['last_name'],
            'email': request.form['email'],
            'password': pw_hash
        }
        #store the user in session
        session['user_id'] = user.User.save(data)
        return redirect('/wall')
    return redirect('/')
#================Login===================#
@app.route('/login',methods=['POST'])
def login():
    data = { 'email': request.form['email']}
    user_in_DB = user.User.get_by_email(data)
    if user_in_DB:
        #validate user input
        if bcrypt.check_password_hash(user_in_DB.password, request.form['password']):
            #store user in session
            session['user_id'] = user_in_DB.id
            return redirect('/wall')
        flash("Invalid Credentials","loginError")
        return redirect('/')
#================Logout===================#
@app.route('/logout')
def logout():
    session.clear()
    return redirect('/')