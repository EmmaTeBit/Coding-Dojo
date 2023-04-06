from flask import Flask,render_template,request,redirect,session
import random #to generate a random INTEGER

app = Flask(__name__)

app.secret_key="em was here"

# @app.route('/')
# def hello_world():
#     return 'Hello World!'

#!=======================USE ABOVE FOR TESTING===================================!


@app.route('/')
def index():
    if "num" not in session:
        session['num'] = random.randint(1,100)

    return render_template("index.html")

@app.route('/guess',methods=['POST'])
def guess():
    session['guess'] = int(request.form['guess'])
    return redirect('/')

@app.route('/reset')
def reset():
    session.clear()
    return redirect('/')
    

#!=======================USE Below FOR TESTING===================================!

if __name__=="__main__":
    app.run(debug=True)