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
		axios.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem("token");
        return axios.get(API_URL + "/users/");
    }

    static get() 
    {
		axios.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem("token");
        return axios.get(API_URL + "/me");
    }

    static create(x)
    {
		axios.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem("token");
        return axios.post(API_URL + "/users/", x);
    }

    static update(data) 
    {
		axios.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem("token");
        return axios.put(API_URL + "/client/" + localStorage.getItem("clientId"), data);
    }

    static delete(id) 
    {
		axios.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem("token");
        return axios.delete(API_URL + "/users/" + id);
    }

    static logOut(){
		axios.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem("token");
        return axios.post(API_URL + "/users/logOut");
    }
}
