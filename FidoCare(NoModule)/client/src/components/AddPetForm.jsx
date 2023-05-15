import axios from "axios";
import "./Style.css";
import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

const AddPetForm = () => {
  const [name, setName] = useState("");
  const [breed, setBreed] = useState("");
  const [weight, setWeight] = useState("");
  const [gender, setGender] = useState("");
  const [location, setLocation] = useState("");
  const [description, setDescription] = useState("");
  const [jobTitle, setJobTitle] = useState("");

  const [errors, setErrors] = useState({});
  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();
    axios
      .post("http://localhost:8000/api/pet", {
        name,
        breed,
        weight,
        gender,
        location,
        description,
        jobTitle,
      })
      .then((response) => {
        navigate("/dashboard");
      })
      .catch((err) => {
        setErrors(err.response.data.err.errors);
      });
  };

  return (
    <div className="show-details-container">
      <div className="show-details">
        <div className="navBar">
          <h1>Share Your Pet's Needs</h1>
          <Link className="button-62" to="/dashboard">
            Back
          </Link>
        </div>
        <hr />{" "}
        <form onSubmit={handleSubmit}>
          <div className="mb-3">
            <label htmlFor="jobTitle" className="form-label">
              Job Title
            </label>
            <input
              type="text"
              className="form-control"
              onChange={(e) => setJobTitle(e.target.value)}
              value={jobTitle}
            />
            {errors.jobTitle ? (
              <p className="error-message">{errors.jobTitle.message}</p>
            ) : null}
          </div>
          <div className="mb-3">
            <label htmlFor="name" className="form-label">
              Pet Name
            </label>
            <input
              type="text"
              className="form-control "
              onChange={(e) => setName(e.target.value)}
              value={name}
            />
            {errors.name ? (
              <p className="error-message">{errors.name.message}</p>
            ) : null}
          </div>

          <div className="mb-3">
            <label htmlFor="breed" className="form-label">
              Breed
            </label>
            <input
              type="text"
              className="form-control"
              onChange={(e) => setBreed(e.target.value)}
              value={breed}
            />
            {errors.breed ? (
              <p className="error-message">{errors.breed.message}</p>
            ) : null}
          </div>
          <div className="mb-3">
            <label htmlFor="weight" className="form-label">
              Weight
            </label>
            <input
              type="number"
              className="form-control"
              onChange={(e) => setWeight(e.target.value)}
              value={weight}
            />
            {errors.weight ? (
              <p className="error-message">{errors.weight.message}</p>
            ) : null}
          </div>
          <div className="mb-3">
            <label htmlFor="gender" className="form-label">
              Gender
            </label>
            <select
              className="form-control"
              onChange={(e) => setGender(e.target.value)}
              value={gender}
            >
              <option value="">Select Gender</option>
              <option value="Male">Male</option>
              <option value="Female">Female</option>
            </select>
            {errors.gender ? (
              <p className="error-message">{errors.gender.message}</p>
            ) : null}
          </div>

          <div className="mb-3">
            <label htmlFor="location" className="form-label">
              Location
            </label>
            <input
              type="text"
              className="form-control"
              onChange={(e) => setLocation(e.target.value)}
              value={location}
              placeholder="Seattle, WA"
            />
            {errors.location ? (
              <p className="error-message">{errors.location.message}</p>
            ) : null}
          </div>
          <div className="mb-3">
            <label htmlFor="description" className="form-label">
              Pet Description
            </label>
            <input
              type="text"
              className="form-control"
              onChange={(e) => setDescription(e.target.value)}
              value={description}
              placeholder="What are your pet's needs?"
            />
            {errors.description ? (
              <p className="error-message">{errors.description.message}</p>
            ) : null}
          </div>

          <button type="submit" className="button-62">
            Post Job
          </button>
        </form>
      </div>
    </div>
  );
};

export default AddPetForm;
