from flask_app import app
from flask import redirect, render_template, request, session
from flask_app.models.user import User

@app.route('/')
def index():
    return redirect ('/home')

@app.route('/home')
def home():
    return render_template('home.html', all_users = User.get_all(),
    display_relationships=User.display_relationships())

@app.route('/add', methods=['POST'])
def add_user():
    data = {
        'first_name':request.form['first_name'],
        'last_name':request.form['last_name']
    }
    user = User.save(data)
    return redirect ('/')

@app.route('/user/<int:id>')
def user(id):
    data = {
        "id": id
    }
    # users = users -pulling users from get_all method returning 'users'
    return render_template('home.html',users= users)

@app.route('/join', methods=['POST'])
def join():
    data = {
        'user_id': request.form['user_id'],
        'friend_id': request.form['friend_id']
    }
    print("A")
    print(data)
    User.add_friends(data)
    return redirect ('/')