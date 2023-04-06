from flask import Flask,render_template,request,redirect,session

app = Flask(__name__)

app.secret_key="Em waz Here"

#!=======================USE ABOVE FOR TESTING===================================!


@app.route('/')
def index():
    return render_template("index.html")

@app.route('/process', methods=['POST'])
def process():
    # saving to session
    session["name"] = request.form["name"]
    session["location"] = request.form["location"]
    session["language"] = request.form["language"]
    session["comments"] = request.form["comments"]
    # Never render a template on a POST request.
    return redirect('/success')

@app.route('/success')
def success():
    return render_template('success.html')

#!=======================USE Below FOR TESTING===================================!

if __name__=="__main__":
    app.run(debug=True)