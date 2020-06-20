import { API_URL } from "./../../config";
import axios from "axios"

export default class AdService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static list() 
    {
		axios.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem("token");
        return axios.get(API_URL + "/ad/");
    }

    static get(id) 
    {
		axios.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem("token");

        return axios.get(API_URL + "/ad/" + id);
    }
    
    

    static create(x)
    {
		axios.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem("token");

        return axios.post(API_URL + "/ad/", x);
    }

    static update(id, data) 
    {
		axios.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem("token");

        return axios.post(API_URL + "/ad/" + id, data);
    }

    static delete(id) 
    {
		axios.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem("token");

        return axios.delete(API_URL + "/ad/" + id);
    }
}