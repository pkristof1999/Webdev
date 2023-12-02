import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import ApiService from '../services/ApiService';

const CpuList = () => {
    const [cpus, setCPUs] = useState([]);

    useEffect( () => {
        ApiService.getCPUList()
            .then((response) => setCPUs(response.data))
            .catch((error) => console.error('Error fetching CPUs:', error));
    }, []);

    console.log(cpus);

    return (
        <div className={"main-container"}>
            <h2>CPU List</h2>
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Gyártó</th>
                    <th>Model</th>
                    <th>Frekvencia</th>
                    <th>Magok száma</th>
                    <th>Értékelések</th>
                    <th>Törlés</th>
                </tr>
                </thead>
                <tbody>
                {cpus.map((cpu) => (
                    <tr key={cpu.id}>
                        <td>{cpu.id}</td>
                        <td>{cpu.manufacturer}</td>
                        <td>{cpu.model}</td>
                        <td>{cpu.frequency}</td>
                        <td>{cpu.coreCount}</td>
                        <td><Link to={`/ReviewForCpu/${cpu.id}`}>Értékelések</Link></td>
                        <td><button>Delete</button></td>
                    </tr>
                ))}
                </tbody>
            </table>
            <Link to="/CpuUpload">Add CPU</Link>
        </div>
    );
};

export default CpuList;