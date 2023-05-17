import { BrowserRouter, Route, Routes } from "react-router-dom";
import CreatePlant from "./components/CreatPlant";
import Dashboard from "./components/Dashboard";
import EditPlant from "./components/EditPlant";
import DetailPlant from "./components/DetailPlant";
import FlippableCard from "./components/FlippableCard";
import FlipCard from "./components/FlipCard";
function App() {
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/plant/new" element={<CreatePlant />} />
          <Route path="/plant/:id/edit" element={<EditPlant />} />
          <Route path="/plant/:id" element={<DetailPlant />} />
          <Route path="/plant/test" element={<FlippableCard />} />
          <Route path="/plant/card" element={<FlipCard />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
