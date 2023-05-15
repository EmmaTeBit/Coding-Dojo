import "../App.css";
import axios from "axios";
import { useParams, Link, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";

const Dashboard = () => {
  const [allPets, setAllPets] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    axios
      .get("http://localhost:8000/api/pet")
      .then((response) => {
        setAllPets(response.data);
      })
      .catch((err) => {
        // Handle error
      });
  }, []);

  const handleDelete = (idFromBelow) => {
    axios
      .delete(`http://localhost:8000/api/pet/${idFromBelow}`)
      .then((response) => {
        // remove the deleted pet from the allPets state
        const updatedPets = allPets.filter((pet) => pet._id !== idFromBelow);
        setAllPets(updatedPets);

        // console.log("success on deleting a pet");
      })
      .catch((err) => {
        // console.log("error deleting a pet", err.response);
      });
  };

  return (
    <div className="dashboard-container">
      <div className="row dashboard">
        {/* --------------------NAV BAR--------------------------------------- */}
        <div className="navBar-welcome">
          <div className="img-welcome">
            <div>
              <img
                src="../images/Phonedog.png"
                alt="Pet Icon"
                className="petDashboardImage"
              />
            </div>
            <div>
              <h1>Welcome to FidoCare!</h1>
              <p>Keeping Your Dog's Tail Wagging!</p>
            </div>
          </div>
          <div>
            <Link to="/pets/new" className="button-62">
              Post a Job
            </Link>
          </div>
        </div>
        {/* --------------------NAV BAR--------------------------------------- */}

        <table className="table table-bordered table-striped table-hover">
          <thead>
            <tr>
              <th>Pet's Name</th>
              <th>Care</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {allPets.map((pet, index) => {
              return (
                <tr key={pet._id}>
                  <td>{pet.name}</td>
                  <td>{pet.jobTitle}</td>
                  <td>
                    <Link
                      className="button-62"
                      onClick={() => handleDelete(pet._id)}
                      style={{ marginRight: "10px" }}
                    >
                      Accept Job
                    </Link>
                    <Link
                      to={`/pets/${pet._id}`}
                      className="button-62"
                      style={{ marginRight: "10px" }}
                    >
                      Details
                    </Link>
                    <Link
                      to={`/pets/${pet._id}/edit`}
                      className="button-62"
                      style={{ marginRight: "10px" }}
                    >
                      Edit
                    </Link>
                  </td>
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default Dashboard;
