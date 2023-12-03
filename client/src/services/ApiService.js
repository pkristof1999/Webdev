import axios from "axios";

const API_URL = "http://localhost:9090/api";

const ApiService = {
    getCPUList: () => axios.get(`${API_URL}/cpu/list`),
    createCPUEntry: (data) => axios.post(`${API_URL}/cpu/upload`, data),
    deleteCPUEntry: (id) => axios.delete(`${API_URL}/cpu/delete/${id}`),
    getReviews: (cpu_id) => axios.get(`${API_URL}/review/list/${cpu_id}`),
    createReview: (cpu_id, data) => axios.post(`${API_URL}/review/upload/${cpu_id}`, data),
    deleteReviewEntry: (review_id) => axios.delete(`${API_URL}/review/delete/${review_id}`)
}

export default ApiService;