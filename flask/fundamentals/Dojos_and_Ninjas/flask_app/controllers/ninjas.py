from flask import render_template, redirect, request, url_for
from flask_app import app
from flask_app.models import dojo, ninja
from flask_app.models.ninja import Ninja

@app.route('/ninjas')
def ninjas():
    # dojo.Dojo.get_all comes from line 3 - dojo.py that contains class Dojo
    return render_template('ninja.html', dojos = dojo.Dojo.get_all())


@app.route('/create/ninja', methods= ['POST'])
def create_ninja():
    ninja.Ninja.save(request.form)
    return redirect('/')

#!=======================VIEW-EDIT-DESTROY===================================!
@app.route('/ninja/edit/<int:id>')
def edit(id):
    data ={ 
        "id":id
    }
    return render_template("edit_ninja.html", ninja = Ninja.get_one(data))


@app.route('/ninja/show/<int:id>')
def show(id):
    data ={ 
        "id":id
    }
    return render_template("show_ninja.html", ninja = Ninja.get_one(data))


@app.route('/ninja/update/<int:dojo_id>',methods=['POST'])
def update(dojo_id):
    Ninja.update(request.form) #request.form is already a request.form check edit_html under name=id
    return redirect(f'/dojo/{dojo_id}')


@app.route('/ninja/destroy/<int:id>/<int:dojo_id>')
def destroy(id,dojo_id):
    data ={
        'id': id #came from ninja.py def destroy needs to match "id" key value
    }
    Ninja.destroy(data)
    return redirect(f'/dojo/{dojo_id}')
