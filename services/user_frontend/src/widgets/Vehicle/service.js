import { API_URL } from "./../../config";
import axios from "axios"

export default class VehicleService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static list() 
    {
		axios.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem("token");

        return axios.get(API_URL + "/vehicles/");
    }

    static get(id) 
    {
		axios.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem("token");

        return axios.get(API_URL + "/vehicles/" + id);
    }
    
    
    
    static order(id, data) 
    {
		axios.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem("token");

        return axios.post(API_URL + "/vehicles/" + id + "/order", data);
    }
    
    

    static create(x)
    {
		axios.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem("token");

        return axios.post(API_URL + "/vehicles/", x);
    }

    static update(id, data) 
    {
		axios.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem("token");

        return axios.post(API_URL + "/vehicles/" + id, data);
    }

    static delete(id) 
    {
		axios.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem("token");

        return axios.delete(API_URL + "/vehicles/" + id);
    }
}