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
        return axios.get(API_URL + "/orders/");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/orders/" + id);
    }
    
    
    
    static dummy(id) 
    {
        return axios.get(API_URL + "/orders/" + id + "/dummy");
    }
    
    

    static create(x)
    {
        return axios.post(API_URL + "/orders/", x);
    }

    static update(id, data) 
    {
        return axios.post(API_URL + "/orders/" + id, data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/orders/" + id);
    }
}