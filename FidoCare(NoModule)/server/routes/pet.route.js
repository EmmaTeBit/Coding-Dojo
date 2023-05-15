//-----------Change Controller/Route Name------------------------------------
const petController = require("../controllers/pet.controller");
module.exports = (app) => {
  //Create
  app.post("/api/pet", petController.createNew);

  //Retrieve
  app.get("/api/pet", petController.getAll);
  app.get("/api/pet/:id", petController.getOne);

  //Update
  app.put("/api/pet/:id", petController.update);

  //Destroy
  app.delete("/api/pet/:id", petController.destroy);
};
