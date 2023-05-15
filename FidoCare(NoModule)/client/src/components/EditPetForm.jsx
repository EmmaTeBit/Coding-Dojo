import axios from "axios";
import React, { useEffect, useState } from "react";
import { useParams, Link, useNavigate } from "react-router-dom";

const EditPetForm = (props) => {
  const { id } = useParams();
  const [petName, setPetName] = useState("");
  const [petBreed, setPetBreed] = useState("");
  const [petWeight, setPetWeight] = useState("");
  const [petGender, setPetGender] = useState("");
  const [petLocation, setPetLocation] = useState("");
  const [petDescription, setPetDescription] = useState("");
  const [petJobTitle, setPetJobTitle] = useState("");

  const [errors, setErrors] = useState({});
  const [petNotFound, setPetNotFound] = useState("");
  const navigate = useNavigate();

  useEffect(() => {
    axios
      .get(`http://localhost:8000/api/pet/${id}`)
      .then((response) => {
        setPetName(response.data.name);
        setPetBreed(response.data.breed);
        setPetWeight(response.data.weight);
        setPetGender(response.data.gender);
        setPetLocation(response.data.location);
        setPetDescription(response.data.description);
        setPetJobTitle(response.data.jobTitle);
      })
      .catch((err) => {
        setPetNotFound(`Pet not found using that ID`);
      });
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();

    axios
      .put(`http://localhost:8000/api/pet/${id}`, {
        name: petName,
        breed: petBreed,
        weight: petWeight,
        gender: petGender,
        location: petLocation,
        description: petDescription,
        jobTitle: petJobTitle,
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
          <h1>{petName}</h1>
          <Link className="button-62" to="/dashboard">
            Back to Home
          </Link>
        </div>
        <form onSubmit={handleSubmit}>
          {petNotFound ? (
            <p>
              {petNotFound} <Link to="/add-pet">Add a pet</Link>
            </p>
          ) : null}
          <div className="bodyBox">
            <div>
              <div className="mb-3">
                <label htmlFor="jobTitle" className="form-label">
                  Job Title
                </label>
                <input
                  type="text"
                  className="form-control"
                  onChange={(e) => setPetJobTitle(e.target.value)}
                  value={petJobTitle}
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
                  className="form-control"
                  onChange={(e) => setPetName(e.target.value)}
                  value={petName}
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
                  onChange={(e) => setPetBreed(e.target.value)}
                  value={petBreed}
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
                  type="text"
                  className="form-control"
                  onChange={(e) => setPetWeight(e.target.value)}
                  value={petWeight}
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
                  className="form-select"
                  onChange={(e) => setPetGender(e.target.value)}
                  value={petGender}
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
                  onChange={(e) => setPetLocation(e.target.value)}
                  value={petLocation}
                />
                {errors.location ? (
                  <p className="error-message">{errors.location.message}</p>
                ) : null}
              </div>

              <div className="mb-3">
                <label htmlFor="description" className="form-label">
                  Description
                </label>
                <input
                  type="text"
                  className="form-control"
                  onChange={(e) => setPetDescription(e.target.value)}
                  value={petDescription}
                />
                {errors.description ? (
                  <p className="error-message">{errors.description.message}</p>
                ) : null}
              </div>
            </div>
            <div></div>
          </div>
          <button type="submit" className="button-62">
            Update
          </button>
        </form>
      </div>
    </div>
  );
};

export default EditPetForm;
