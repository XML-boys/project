import { API_URL } from "./../../config";
import axios from "axios"

export default class OrderService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static list() 
    {
		axios.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem("token");

        return axios.get(API_URL + "/orders/");
    }

    static get(id) 
    {
		axios.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem("token");

        return axios.get(API_URL + "/orders/" + id);
    }
    
    
    
    static dummy(id) 
    {
		axios.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem("token");

        return axios.get(API_URL + "/orders/" + id + "/dummy");
    }
    
    

    static create(x)
    {
		axios.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem("token");

        return axios.post(API_URL + "/orders/", x);
    }

    static update(id, data) 
    {
		axios.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem("token");

        return axios.post(API_URL + "/orders/" + id, data);
    }

    static delete(id) 
    {
		axios.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem("token");

        return axios.delete(API_URL + "/orders/" + id);
    }
}