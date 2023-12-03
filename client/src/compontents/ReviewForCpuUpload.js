import React, { useState } from 'react';
import {useLocation, useNavigate} from 'react-router-dom';
import ApiService from '../services/ApiService';
import '../styles/styles.css'

const ReviewForCpuUpload = () => {
	const { state } = useLocation();
	const { cpuID } = state || {};
	const navigate = useNavigate();
	const [reviewText, setReviewText] = useState("")
	const [score, setScore] = useState("")
	const [selectedItem, setSelectedItem] = useState("Ajánlás: Ajánlott");
	const [isDropdownOpen, setIsDropdownOpen] = useState(false);

	console.log(selectedItem)

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

	const handleDropdownItemClick = (value) => {
		setSelectedItem(value);
		setIsDropdownOpen(false);
	};

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
				<div className={`dropdown ${isDropdownOpen ? "active-dropdown" : ""}`}>
					<button
						className={"dropbtn"}
						onClick={() => setIsDropdownOpen(!isDropdownOpen)}>
                        <span>{selectedItem || "Ajánlás: Ajánlott"}</span>
						<span className="dropbtn-arrow">
                            &#9660;
                        </span>
					</button>
					<div id="myDropdown">
						<div className={"dropdown-content"}>
							<p onClick={() => handleDropdownItemClick("Ajánlás: Ajánlott")}>
								Ajánlás: Ajánlott
							</p>
							<p onClick={() => handleDropdownItemClick("Ajánlás: Nem Ajánlott")}>
								Ajánlás: Nem Ajánlott
							</p>
						</div>
					</div>
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
