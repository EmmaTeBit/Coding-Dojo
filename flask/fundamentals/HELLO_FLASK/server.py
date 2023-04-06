from flask import Flask, render_template
app = Flask(__name__)

@app.route('/')
def index():
    return render_template("index.html")
    # Instead of returning a string, 
    # we'll return the result of the render_template method, passing in the name of our HTML file
    
@app.route('/success')
def success():
    return "Success"

@app.route('/hello/<string:name>/<int:num>')
def hello(name,num):
    return render_template("hello.html", name = name, num = num)

# @app.route('/hello/<string:name>/<int:num>')
# def hello(name,num):
#     return f"hello {name * num}"
# #http://127.0.0.1:5000/hello/Derek/5 = hello DerekDerekDerekDerekDerek

@app.route('/users/<username>/<id>') # for a route '/users/____/____', two parameters in the url get passed as username and id
def show_user_profile(username, id):
    print(username)
    print(id)
    return "username: " + username + ", id: " + id
#http://127.0.0.1:5000/users/Emma/4   =  username: Emma, id: 4



if __name__=="__main__":   # Ensure this file is being run directly and not from a different module    
    app.run(debug=True)    # Run the app in debug mode.

