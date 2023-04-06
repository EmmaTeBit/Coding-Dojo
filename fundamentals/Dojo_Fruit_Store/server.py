from flask import Flask, render_template, request, redirect
app = Flask(__name__)  


# create 2 global dict 1 for fruit 1 for student
# fruitlist = [
#     {'name': 'strawberry', 'quanity':0},
#     {'name': 'raspberry', 'quanity':0},
#     {'name': 'apple', 'quanity':0},
    
# ]

#!=======================USE ABOVE FOR TESTING===================================!
@app.route('/')         
def index():
    return render_template("index.html")

@app.route('/checkout', methods=['POST'])         
def checkout():
    print(request.form)
    # saving values to local varaible
    strawberry = request.form['strawberry']
    raspberry = request.form['raspberry']
    apple = request.form['apple']
    first_name = request.form['first_name']
    last_name = request.form['last_name']
    student_id = request.form['student_id']
    
    total = (int(strawberry)+int(raspberry)+int(apple))
    # refactor to redirect to /fruits
    return redirect('/fruits', bear=strawberry, rasp=raspberry, 
    apple=apple,first_name=first_name, last_name=last_name, student_id=student_id,
    total=total)

@app.route('/fruits')         
def fruits():
    return render_template("fruits.html")


#!=======================USE Below FOR TESTING===================================!
if __name__=="__main__":   
    app.run(debug=True)        