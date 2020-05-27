import { API_URL } from "./../../config";
import axios from "axios"

export default class UserService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static list() 
    {
        return axios.get(API_URL + "/users/");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/users/" + id);
    }

    static create(x)
    {
        return axios.post(API_URL + "/users/", x);
    }

    static update(data) 
    {
        return axios.post(API_URL + "/updateProfile/", data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/users/" + id);
    }

    static logOut(){
        return axios.post(API_URL + "/users/logOut");
    }
}
