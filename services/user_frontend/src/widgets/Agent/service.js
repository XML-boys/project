import { API_URL } from "./../../config";
import axios from "axios"

export default class AgentService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static list() 
    {
        return axios.get(API_URL + "/agents/");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/agents/" + id);
    }
    
    
    
    static cars(id) 
    {
        return axios.get(API_URL + "/agents/" + id + "/cars");
    }
    
    

    static create(x)
    {
        return axios.post(API_URL + "/agents/", x);
    }

    static update(id, data) 
    {
        return axios.post(API_URL + "/agents/" + id, data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/agents/" + id);
    }
}