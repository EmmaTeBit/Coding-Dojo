import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useFormik } from "formik";
import "./Style.css";

const RegisterAndLogin = () => {
  const [errors, setErrors] = useState({});
  const navigate = useNavigate();

  const registerUser = (userData) => {};
  const loginUser = (userData) => {};

  const registerFormik = useFormik({
    initialValues: {
      username: "",
      email: "",
      password: "",
      confirmPassword: "",
    },
    onSubmit: (values) => {
      console.log("Registration form submitted:", values);
      // Perform registration request here
      registerUser(values)
        .then((response) => {
          navigate("/dashboard");
        })
        .catch((err) => {
          setErrors(err.response.data.err.errors);
        });
    },
  });

  const loginFormik = useFormik({
    initialValues: {
      email: "",
      password: "",
    },
    onSubmit: (values) => {
      console.log("Login form submitted:", values);
      // Perform login request here
      loginUser(values)
        .then((response) => {
          navigate("/");
        })
        .catch((err) => {
          setErrors(err.response.data.err.errors);
        });
    },
  });

  return (
    <div className="login-container">
      <div className="login">
        <h1>Register</h1>
        <hr />
        <form onSubmit={registerFormik.handleSubmit}>
          <label className="form-label">
            Username:
            <input
              type="text"
              name="username"
              value={registerFormik.values.username}
              onChange={registerFormik.handleChange}
              className="form-control"
            />
            {errors.username ? (
              <p className="error-message">{errors.username.message}</p>
            ) : null}
          </label>
          <br />
          <label className="form-label">
            Email:
            <input
              type="email"
              name="email"
              value={registerFormik.values.email}
              onChange={registerFormik.handleChange}
              className="form-control"
            />
          </label>
          <br />
          <label className="form-label">
            Password:
            <input
              type="password"
              name="password"
              value={registerFormik.values.password}
              onChange={registerFormik.handleChange}
              className="form-control"
            />
          </label>
          <br />
          <label className="form-label">
            Confirm Password:
            <input
              type="password"
              name="confirmPassword"
              value={registerFormik.values.confirmPassword}
              onChange={registerFormik.handleChange}
              className="form-control"
            />
          </label>
          <br />
          <button className="button-62" type="submit">
            Register
          </button>
        </form>
      </div>
      {/* ------------------------------------------------------------------------------ */}
      <div className="login">
        <h1>Login</h1>
        <hr />

        <form onSubmit={loginFormik.handleSubmit}>
          <label className="form-label">
            Email:
            <input
              type="email"
              name="email"
              value={loginFormik.values.email}
              onChange={loginFormik.handleChange}
              className="form-control"
            />
          </label>
          <br />
          <label className="form-label">
            Password:
            <input
              type="password"
              name="password"
              value={loginFormik.values.password}
              onChange={loginFormik.handleChange}
              className="form-control"
            />
          </label>
          <br />
          <button className="button-62" type="submit">
            Login
          </button>
        </form>
      </div>
    </div>
  );
};

export default RegisterAndLogin;
