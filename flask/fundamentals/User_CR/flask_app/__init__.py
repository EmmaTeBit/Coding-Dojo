from flask import Flask

app = Flask(__name__)

app.secret_key = "Yoyoyoyoyo"
from flask_app.controllers import users