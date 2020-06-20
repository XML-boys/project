import { API_URL } from "./../../config";
import axios from "axios"

export default class LoginService 
{
    constructor(self) 
    {
        this.self = self;
    }


    static login(x)
    {
		axios.defaults.headers.common['Authorization'] = "";
        return axios.post(API_URL + "/auth", x);
    }

    static getProfile() {
		axios.defaults.headers.common['Authorization'] = "Bearer " + localStorage.getItem("token");
        return axios.get(API_URL + "/me");
    }

}
