import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import ApiService from '../services/ApiService';

const CpuUpload = () => {
	const [cpuData, setCPUData] = useState({
		manufacturer: '',
		model: '',
		frequency: '',
		coreCount: 0,
	});

	const navigate = useNavigate();

	const handleChange = (e) => {
		setCPUData({ ...cpuData, [e.target.name]: e.target.value });
	};

	const handleSubmit = (e) => {
		e.preventDefault();
		ApiService.createCPUEntry(cpuData)
			.then(() => navigate('/CPUList'))
			.catch((error) => console.error('Error creating CPU:', error));
	};

	return (
		<div>
			<h2>Add CPU</h2>
			<form onSubmit={handleSubmit}>
				<button type="submit">Submit</button>
			</form>
		</div>
	);
};

export default CpuUpload;