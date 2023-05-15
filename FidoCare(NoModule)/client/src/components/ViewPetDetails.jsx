import axios from "axios";
import React, { useEffect, useState } from "react";
import { useParams, Link, useNavigate } from "react-router-dom";

const ViewPetDetails = (props) => {
  const [pet, setPet] = useState({});
  const { id } = useParams();
  // const navigate = useNavigate();

  useEffect(() => {
    axios
      .get("http://localhost:8000/api/pet/" + id)
      .then((res) => {
        console.log(res.data);
        setPet(res.data);
      })
      .catch((err) => console.log(err));
  }, []);

  // const handleDelete = (idFromBelow) => {
  //   axios
  //     .delete(`http://localhost:8000/api/pet/${idFromBelow}`)
  //     .then((response) => {
  //       navigate("/dashboard");
  //       // console.log("success on deleteing a pet");
  //     })
  //     .catch((err) => {
  //       // console.log("error deleting a pet", err.response);
  //     });
  // };
  return (
    <div className="show-details-container">
      <div className="show-details">
        <div className="navBar">
          <div className="navBar-PetName">
            <div>
              <img
                src="../images/Fido.png"
                alt="Pet Icon"
                className="petIconImage"
              />
            </div>
            <h1 style={{ marginLeft: "10px" }}> {pet.name}</h1>
          </div>
          <Link className="button-62" to="/dashboard">
            Back to Home
          </Link>
        </div>

        <div>
          <h5>{pet.breed}</h5>
          <h6>
            {pet.weight}lb - {pet.gender}
          </h6>
          <hr />
          <h5 className="show-description">Description: {pet.description}</h5>
          <h5 className="show-description">Location: {pet.location}</h5>
          <hr />
          {/* <h5 className="show-duration">Posted By: </h5>
          <h5 className="show-duration">Posted On: </h5> */}
          <div className="edit-buttons">
            <div>
              <Link to={`/pets/${pet._id}/edit`} className="button-62">
                Edit
              </Link>
            </div>
            {/* <div>
              <button
                className="button-62"
                onClick={() => handleDelete(pet._id)}
              >
                Delete
              </button>
            </div> */}
          </div>
        </div>
      </div>
    </div>
  );
};
export default ViewPetDetails;
