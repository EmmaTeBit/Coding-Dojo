from flask import render_template,redirect,session,request
from flask_app import app
from flask_app.models.user import User
from flask import flash
#================================================================
@app.route('/')
def index():
    return render_template('index.html')
#================================================================
@app.route('/register',methods=['POST'])
def register():
    valid_user = User.create_valid_user(request.form)
    
    if not valid_user:
        return redirect('/')
    session['user_id'] = valid_user.id
    
    return redirect('sighting/dashboard')
#================================================================
@app.route('/login',methods=['POST'])
def login():
    valid_user = User.authenticated_user_by_input(request.form)
    if not valid_user:
        return redirect('/')
    session['user_id'] = valid_user.id
    return redirect('sightings/dashboard')
#================================================================

@app.route('/logout')
def logout():
    session.clear()
    return redirect('/')