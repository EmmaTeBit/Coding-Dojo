const mongoose = require("mongoose");

const PetSchema = {
  name: {
    type: String,
    required: [true, "Name is required"],
    minLength: [3, "Name requires at least 3 characters"],
  },
  breed: {
    type: String,
    required: [true, "Breed is required"],
    minLength: [1, "Breed requires at least 1 character"],
  },
  weight: {
    type: Number,
    required: [true, "Weight is required"],
    min: [1, "Weight must be at least 1 lb"],
  },
  gender: {
    type: String,
    enum: ["Male", "Female"], // Accepts only "male" or "female"
    required: [true, "Gender is required"],
  },
  location: {
    type: String,
    required: [true, "Location is required"],
    minLength: [3, "Location requires at least 3 characters"],
  },
  description: {
    type: String,
    required: [true, "Description is required"],
    minLength: [3, "Description requires at least 3 characters"],
  },
  jobTitle: {
    type: String,
    required: [true, "Job Title is required"],
    minLength: [1, "Job Title requires at least 1 character"],
  },
};

module.exports = mongoose.model("Pet", PetSchema);
