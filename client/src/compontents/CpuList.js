import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import ApiService from '../services/ApiService';
import "../styles/styles.css";

const CpuList = () => {
    const navigate = useNavigate();
    const [cpus, setCPUs] = useState([]);

    useEffect( () => {
        ApiService.getCPUList()
            .then((response) => setCPUs(response.data))
            .catch((error) => console.error("Hiba a CPU-k betöltésénél:", error));
    }, []);

    const navigateCpuUpload = () => {
        navigate("/CpuUpload");
    }

    const handleCPUEntryDelete = (cpuId) => {
        const confirmDelete = window.confirm("Biztosan kitörli a CPU-t a listából?");

        if (confirmDelete) {
            ApiService.deleteCPUEntry(cpuId)
                .then(() => {
                    window.location.reload();
                })
                .catch((error) => {
                    console.error('Error deleting CPU:', error);
                })
        }
    }


    return (
        <div className={"main-container"}>
            <h2>Processzorok listája</h2>
            <div className={"board-blur-container"}/>
            <div className={"board-container"}>
                <table>
                    <thead className={"thead-style"}>
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
                            <td>
                                <Link className={"table-button-style link"} to={`/ReviewForCpu/${cpu.id}`}>Értékelések</Link>
                            </td>
                            <td>
                                <button className={"table-button-style"}
                                        onClick={() => handleCPUEntryDelete(cpu.id)}>
                                    Törlés
                                </button>
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </table>
                <button className={"button-style"}
                        onClick={navigateCpuUpload}>
                    Processzor Hozzáadása
                </button>
            </div>
        </div>
    );
};

export default CpuList;