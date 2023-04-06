from flask import Flask,render_template,session,redirect
app = Flask(__name__)
app.secret_key="em was here"


# @app.route('/')
# def hello_world():
#     return 'Hello World!'

#!=======================USE ABOVE FOR TESTING===================================!


@app.route('/')
def index():
    if "count" not in session:
        session["count"] = 0
    else:
        session["count"] += 1
    return render_template("index.html")

@app.route('/reset')
def reset():
    session.clear()
    return redirect('/')

#!=======================USE Below FOR TESTING===================================!

if __name__=="__main__":
    app.run(debug=True)