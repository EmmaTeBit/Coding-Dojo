from flask_app import app
from flask import render_template,redirect,request,session,flash
from flask_app.models import post
#==============================================#
@app.route('post/create', methods=['POST'])
def post_post():
    if 'user_id' in session:
        if post.Post.validate_create(request.form):
            data = {
                'content': request.form['content'],
                'user_id': session['user_id']
            }
            post.Post.save(data)
        return redirect('/wall')
    return redirect('/')
#==============================================#
@app.route('/post/delete/<int:post_id>')
def delete_post():
    if 'user_id' in session:
        post.Post.delete_by_id({'id':post_id})
        return redirect('/wall')
    return redirect('/')
    