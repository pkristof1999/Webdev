import React, { useEffect, useState } from 'react';
import {useParams, useNavigate} from 'react-router-dom';
import ApiService from '../services/ApiService';

const ReviewForCpu = () => {
	const navigate = useNavigate();
	const { cpuID } = useParams()
	const [reviews, setReviews] = useState([]);

	console.log(cpuID)

	useEffect(() => {
		ApiService.getReviews(cpuID)
			.then((response) => setReviews(response.data))
			.catch((error) => console.error("Hiba az értékelések betöltésénél: ", error));
	}, [cpuID]);

	const navigateCPUList = () => {
		navigate("/CPUList")
	}

	const navigateReviewUpload = () => {
		navigate("/ReviewForCpuUpload", { state: { cpuID } });
	};

	const handleReviewEntryDelete = (reviewID) => {
		const confirmDelete = window.confirm("Biztosan kitörli az értékelést a listából?");

		if (confirmDelete) {
			ApiService.deleteReviewEntry(reviewID)
				.then(() => {
					window.location.reload();
				})
				.catch((error) => {
					console.error("Hiba az értékelés törlésénél: ", error);
				})
		}
	}

	return (
		<div className={"main-container"}>
			<h2>Processzor értékelései</h2>
			<div className={"board-blur-container"}/>
			<div className={"board-container"}>
				<table>
					<thead className={"thead-style"}>
						<tr>
							<th colSpan={2}>Értékelés szövege</th>
							<th>Pontszám</th>
							<th>Ajánlja?</th>
							<th>Művelet</th>
						</tr>
					</thead>
					<tbody>
					{reviews.map((review) => (
						<tr key={review.id}>
							<td colSpan={2}>{review.reviewText}</td>
							<td>{review.score}</td>
							<td>{review.recommend ? "Igen" : "Nem"}</td>
							<td>
								<button className={"table-button-style"}
										onClick={() => handleReviewEntryDelete(review.id)}>
									Törlés
								</button>
							</td>
						</tr>
					))}
					</tbody>
				</table>
				<div className={"bottom-buttons"}>
					<button className={"button-style"}
							onClick={navigateReviewUpload}>
						Értékelés Hozzáadása
					</button>
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

export default ReviewForCpu;
