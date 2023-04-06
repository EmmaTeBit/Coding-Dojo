from flask import Flask,render_template,request,redirect,session
import random
from datetime import datetime

app = Flask(__name__)
app.secret_key="Em waz Here"

#!=======================Section Lining==========================================!

@app.route('/')
def index():
    if 'count_gold' not in session:
        session['count_gold']= 0
    if 'log' not in session:
        session['log']=[]
    if 'attempts' not in session:
        session['attempts']= 0 
    return render_template("index.html")

@app.route('/process', methods=['POST'])
def process():
    if session['attempts'] < 15:
        session['attempts'] += 1
        updated_at = datetime.now().strftime("%m/%d/%Y %I:%M%p")
        if request.form['location'] == 'farm':
            gold = random.randint(10,20)
            session['count_gold'] += gold
        if request.form['location'] == 'cave':
            gold = random.randint(5,10)
            session['count_gold'] += gold
        if request.form['location'] == 'house':
            gold = random.randint(2,5)
            session['count_gold'] += gold
        if request.form['location'] == 'casino':
            gold = random.randint(0,50)
            session['count_gold'] += gold
        if gold >= 0:
            session['log'].insert(0, [f"You earned {gold} gold from the {request.form['location']}. ({updated_at})", True])
        else:
            session['log'].insert(0, [f"You earned {gold} gold from the {request.form['location']}. ({updated_at})", False])
            
    else:
        if session['count_gold'] > 300:
            session['result'] = "Winner!"
        else:
            session['result'] = "Try Again....loser!"
    return redirect('/')

@app.route('/reset')
def reset():
    session.clear()
    return redirect('/')

#!=======================USE Below FOR TESTING===================================!

if __name__=="__main__":
    app.run(debug=True)