import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import ApiService from '../services/ApiService';
import "../styles/styles.css";

const CpuUpload = () => {
	const [manufacturer, setManufacturer] = useState("")
	const [model, setModel] = useState("")
	const [frequency, setFrequency] = useState("")
	const [coreCount, setCoreCount] = useState("")

	const navigate = useNavigate();

	const handleSubmit = (e) => {
		e.preventDefault();
		try {
			if (
				manufacturer === "" || manufacturer === null
				|| model === "" || model === null
				|| frequency === "" || frequency === null
				|| coreCount === "" || coreCount === null) {
				throw new Error("Nem adott meg minden adatot!");
			} else if (!isNumber(coreCount)) {
			} else {
				const dataToJson = {
					"manufacturer": manufacturer,
					"model": model,
					"frequency": frequency,
					"coreCount": coreCount
				}

				ApiService.createCPUEntry(dataToJson)
					.then(() => navigate("/CPUList"))
					.catch((error) => console.error("Hiba a CPU létrehozásakor: ", error));
			}
		} catch (error) {
			alert(error);
		}
	};

	const navigateCPUList = () => {
		navigate("/CPUList")
	}

	function isNumber(value) {
		const parsedValue = parseInt(value, 10);

		if (isNaN(parsedValue)) {
			throw new Error("Nem egész szám a Magok Száma!");
		}

		return parsedValue;
	}

	return (
		<div className={"main-container"}>
			<h2 className={"cpuupload-h2"}>Processzor hozzáadása</h2>
			<div className={"upload-blur-container"}></div>
			<div className={"upload-container"}>
				<div className = "first-content content">
					<input
						className={"input-field"}
						type="text"
						placeholder="Gyártó"
						id="username"
						value={manufacturer}
						onChange={(e) => setManufacturer(e.target.value)}
					/>
				</div>
				<div className = "content">
					<input
						className={"input-field"}
						type="text"
						placeholder="Model"
						id="username"
						value={model}
						onChange={(e) => setModel(e.target.value)}
					/>
				</div>
				<div className = "content">
					<input
						className={"input-field"}
						type="text"
						placeholder="Frekvencia"
						id="username"
						value={frequency}
						onChange={(e) => setFrequency(e.target.value)}
					/>
				</div>
				<div className = "last-content content">
					<input
						className={"input-field"}
						type="text"
						placeholder="Magok Száma"
						id="username"
						value={coreCount}
						onChange={(e) => setCoreCount(e.target.value)}
					/>
				</div>
				<div className={"bottom-buttons"}>
					<form onSubmit={handleSubmit}>
						<button className={"button-style"} type="submit">Feltöltés</button>
					</form>
				</div>
				<div className={"bottom-buttons"}>
					<button className={"button-style"}
							onClick={navigateCPUList}>
						Visszalépés
					</button>
				</div>
			</div>
		</div>
	);
};

export default CpuUpload;