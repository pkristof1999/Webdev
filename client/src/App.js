import React from "react";
import CpuList from "./compontents/CpuList";
import CpuUpload from "./compontents/CpuUpload";
import ReviewForCpu from "./compontents/ReviewForCpu";
import ReviewForCpuUpload from "./compontents/ReviewForCpuUpload";
import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom";
import './styles/styles.css';

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path = "/" element = { <Navigate to = "/CpuList" /> } />
                <Route path = "/CpuList" element = { < CpuList /> } />
                <Route path = "/CpuUpload" element = { < CpuUpload /> } />
                <Route path = "/ReviewForCpu/:cpu_id" element = { < ReviewForCpu /> } />
                <Route path = "/ReviewForCpuUpload" element = { < ReviewForCpuUpload /> } />
                <Route path = "*" element = { < NotFound /> } />
            </Routes>
        </BrowserRouter>
    );
}

function NotFound() {
    return (
        <div className={"main-container"}>
            <h2 className={"notfound-h2"}>!! 404 !!</h2>
            <p className={"notfound-p"}>A kért oldal nem található!</p>
        </div>
    );
}

export default App;
