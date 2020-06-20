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

    static get() 
    {
        return axios.get(API_URL + "/client/me/user/1/");
    }

    static create(x)
    {
        return axios.post(API_URL + "/users/", x);
    }

    static update(data) 
    {
        return axios.put(API_URL + "/client//" + localStorage.getItem("clientId"), data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/users/" + id);
    }

    static logOut(){
        return axios.post(API_URL + "/users/logOut");
    }
}
