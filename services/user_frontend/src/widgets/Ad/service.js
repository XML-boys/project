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
        return axios.get(API_URL + "/ad/");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/ad/" + id);
    }
    
    

    static create(x)
    {
        return axios.post(API_URL + "/ad/", x);
    }

    static update(id, data) 
    {
        return axios.post(API_URL + "/ad/" + id, data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/ad/" + id);
    }
}