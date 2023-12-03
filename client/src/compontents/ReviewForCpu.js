import React, { useEffect, useState } from 'react';
import { useParams, useLocation } from 'react-router-dom';
import ApiService from '../services/ApiService';

const ReviewForCpu = () => {
	const { cpuID } = useParams()
	const [reviews, setReviews] = useState([]);

	console.log(cpuID)

	useEffect(() => {
		ApiService.getReviews(cpuID)
			.then((response) => setReviews(response.data))
			.catch((error) => console.error('Error fetching reviews:', error));
	}, [cpuID]);

	return (
		<div>
			<h2>Reviews for CPU {cpuID}</h2>
			<ul>
				{reviews.map((review) => (
					<li key={review.id}>
						Reviewer: {review.reviewer}, Score: {review.score}, Recommend: {review.recommend ? 'Yes' : 'No'}
					</li>
				))}
			</ul>
		</div>
	);
};

export default ReviewForCpu;
