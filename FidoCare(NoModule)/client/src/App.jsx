import { BrowserRouter, Route, Routes } from "react-router-dom";
import AddPetForm from "./components/AddPetForm";
import Dashboard from "./components/Dashboard";
import ViewPetDetails from "./components/ViewPetDetails";
import EditPetForm from "./components/EditPetForm";
import Styling from "./components/Styling";
import RegisterAndLogin from "./components/RegisterAndLogin";
function App() {
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<RegisterAndLogin />} />

          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/pets/new" element={<AddPetForm />} />
          <Route path="/pets/:id" element={<ViewPetDetails />} />
          <Route path="/pets/:id/edit" element={<EditPetForm />} />
          <Route path="/bob" element={<Styling />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
