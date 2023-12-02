import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import ApiService from '../services/ApiService';

const ReviewForCpuUpload = ({ cpuId }) => {
	const [reviewData, setReviewData] = useState({
		reviewer: '',
		reviewText: '',
		score: 0,
		recommend: false,
	});

	const navigate = useNavigate();

	const handleChange = (e) => {
		setReviewData({ ...reviewData, [e.target.name]: e.target.value });
	};

	const handleSubmit = async (e) => {
		e.preventDefault();
		try {
			await ApiService.createReview(cpuId, reviewData);
			navigate(`/ReviewForCpu/${cpuId}`);
		} catch (error) {
			console.error('Error creating review:', error);
		}
	};

	return (
		<div>
			<h2>Add Review</h2>
			<form onSubmit={handleSubmit}>
				{/* Review form fields */}
				<button type="submit">Submit</button>
			</form>
		</div>
	);
};

export default ReviewForCpuUpload;
