const User = require("../models/user.model");
const bcrypt = require("bcrypt");

// REGISTRATION
const registerUser = async (req, res) => {
  try {
    const { username, email, password } = req.body;

    // Check if  username / email already exists
    const existingUser = await User.findOne({ $or: [{ username }, { email }] });
    if (existingUser) {
      return res
        .status(400)
        .json({ message: "Username or email already exists" });
    }

    // Create new user instance
    const newUser = new User({ username, email, password });

    // Save user to  DB
    await newUser.save();

    res.status(201).json({ message: "User registered successfully" });
  } catch (error) {
    console.error("Error while registering user:", error);
    res.status(500).json({ message: "Internal server error" });
  }
};

// LOGIN
const loginUser = async (req, res) => {
  try {
    // Get user credentials from request body
    const { email, password } = req.body;

    // Check if user exists in DB
    const user = await User.findOne({ email });
    if (!user) {
      return res.status(404).json({ message: "User not found" });
    }

    // Compare PW with the stored hashed password
    const isPasswordValid = await bcrypt.compare(password, user.password);
    if (!isPasswordValid) {
      return res.status(401).json({ message: "Invalid credentials" });
    }

    //SUCCESSION TOKEN
    res.status(200).json({ message: "Login successful" });
  } catch (error) {
    console.error("Error while logging in:", error);
    res.status(500).json({ message: "Internal server error" });
  }
};

// GET ALL USERS
const getAllUsers = async (req, res) => {
  try {
    const users = await User.find();
    res.status(200).json(users);
  } catch (error) {
    console.error("Error while retrieving users:", error);
    res.status(500).json({ message: "Internal server error" });
  }
};

module.exports = { registerUser, loginUser, getAllUsers };
