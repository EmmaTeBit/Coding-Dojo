from flask_app import app
from flask import render_template,redirect,request,session,flash
#================MODEL imoport===================#
from flask_app.models.user import User
from datetime import datetime
dateFormat = '%m/%d/%Y %I:%M %p'
#================Dashboard===================#
@app.route('/wall')
def dashboard():
    if 'user_id' in session:
        return render_template('dashboard.html',
            current_user = user.User.get_by_id({'id': session['user_id']}),
            all_post = post.Post.get_all()
            )
        return redirect('/')

