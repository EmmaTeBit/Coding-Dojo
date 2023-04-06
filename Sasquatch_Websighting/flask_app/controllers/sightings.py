from flask import render_template,redirect,session,request
from flask_app import app
from flask_app.models.user import User
from flask_app.models.sighting import Sighting
from flask import flash
#================================================================
@app.route('/sighting/dashboard')
def sighting_dashboard():
    if 'user_id' not in session:
        flash("You must be logged in to access the dashboard.")
        return redirect("/")
    
    user = User.get_by_id(session['user_id'])
    sighting = Sighting.get_all()

    return render_template('dashboard.html',user=user, sighting=sighting)
#===========================SHOW SIGHTING=====================================
@app.route('/sightings/<int:sighting_id>')
def sighting_detail(sighting_id):
    user = User.get_by_id(session['user_id'])
    sighting = Sighting.get_by_id(sighting_id)
    return render_template('show.html',user=user,sighting=sighting)
#============================POST====================================
@app.route("/sightings/create")
def sighting_create_page():
    return render_template("sighting.html")
#============================POST====================================
@app.route('/sightings/edit/<int:sightings_id>')
def sighting_edit_page(sightings_id):
    sighting = Sighting.get_by_id(sightings_id)
    return render_template("edit.html", sighting=sighting)
#============================POST====================================
@app.route("/sightings", methods=["POST"])
def report_sighting():
    valid_sighting = Sighting.create_valid_sighting(request.form)
    if valid_sighting:
        return redirect(f'/sightings/{valid_recipe.id}')
    return redirect('/sightings/create')
#===========================ACTION=====================================
@app.route("/sightings/<int:sightings_id>", methods=["POST"])
def update_sighting(sightings_id):

    valid_sighting = Sighting.update_recipe(request.form, session["user_id"])

    if not valid_sighting:
        return redirect(f"/sightings/edit/{sightings_id}")
        
    return redirect(f"/sightings/{sightings_id}")
#===========================ACTION=====================================

@app.route("/sightings/delete/<int:sightings_id>")
def delete_by_id(sightings_id):
    Sighting.delete_sighting_by_id(sightings_id)
    return redirect("/sightings/dashboard")
