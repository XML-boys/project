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
        return axios.post(API_URL + "/login", x);
    }

}
