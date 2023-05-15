const userController = require("../controllers/user.controller");
module.exports = (app) => {
  //REGISTER
  app.post("/api/register", userController.registerUser);

  //LOGIN
  app.post("/api/login", userController.loginUser);

  // GET ALL USERS
  app.get("/api/users", userController.getAllUsers);
};
