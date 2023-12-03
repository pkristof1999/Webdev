import React, { useState } from 'react';
import {useLocation, useNavigate} from 'react-router-dom';
import ApiService from '../services/ApiService';

const ReviewForCpuUpload = () => {
	const { state } = useLocation();
	const { cpuID } = state || {};
	const navigate = useNavigate();
	const [reviewText, setReviewText] = useState("")
	const [score, setScore] = useState("")
	const [recommend, setRecommend] = useState("")

	console.log(cpuID)

	const handleSubmit = async (e) => {
		e.preventDefault();
		try {
			await ApiService.createReview(cpuID);
			navigate(`/ReviewForCpu/${cpuID}`);
		} catch (error) {
			console.error("Hiba az értékelés létrehozásánál: ", error);
		}
	};

	const navigateReviewList = (cpuID) => {
		navigate(`/ReviewForCpu/${cpuID}`)
	}

	return (
		<div className={"main-container"}>
			<h2 className={"upload-h2"}>Értékelés hozzáadása</h2>
			<div className={"upload-blur-container"}></div>
			<div className={"upload-container"}>
				<div className = "first-content content">
					<input
						className={"input-field review-text"}
						type="text"
						placeholder="Értékelés szövege"
						id="reviewText"
						value={reviewText}
						onChange={(e) => setReviewText(e.target.value)}
					/>
				</div>
				<div className = "content">
					<input
						className={"input-field"}
						type="text"
						placeholder="Pontszám"
						id="score"
						value={score}
						onChange={(e) => setScore(e.target.value)}
					/>
				</div>
				<div className = "last-content content">
					<input
						className={"input-field"}
						type="text"
						placeholder="Ájánlás"
						id="recommend"
						value={recommend}
						onChange={(e) => setRecommend(e.target.value)}
					/>
				</div>
				<div className={"bottom-buttons"}>
					<form onSubmit={handleSubmit}>
						<button className={"button-style"} type="submit">Feltöltés</button>
					</form>
				</div>
				<div className={"bottom-buttons"}>
					<button className={"button-style"}
							onClick={() => navigateReviewList(cpuID)}>
						Visszalépés
					</button>
				</div>
			</div>
		</div>
	);
};

export default ReviewForCpuUpload;
