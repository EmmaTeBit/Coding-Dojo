from flask_app import app
from flask import render_template,redirect,request,session,flash
from flask_app.models import comment
#==============================================#
@app.route('/comment/create', methods=['POST'])
def post_comment():
    if 'user_id' in session:
        if comment.Comment.validate_create(request.form):
            data = {
                'content': request.form['content'],
                'user_id': session['user_id'],
                'post_id': session['post_id']
            }
            comment.Comment.save(data)
        return redirect('/wall')
    return redirect('/')