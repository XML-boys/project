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
        return axios.get(API_URL + "/vehicles/");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/vehicles/" + id);
    }
    
    
    
    static order(id, data) 
    {
        return axios.post(API_URL + "/vehicles/" + id + "/order", data);
    }
    
    

    static create(x)
    {
        return axios.post(API_URL + "/vehicles/", x);
    }

    static update(id, data) 
    {
        return axios.post(API_URL + "/vehicles/" + id, data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/vehicles/" + id);
    }
}