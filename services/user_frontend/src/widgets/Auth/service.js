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
        return axios.post(API_URL + "/auth", x);
    }

    static getProfile() {
        return axios.get(API_URL + "/client/me/user/1");
    }

}
