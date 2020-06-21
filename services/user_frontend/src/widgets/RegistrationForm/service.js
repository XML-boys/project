import { API_URL } from "./../../config";
import axios from "axios"

export default class RegistrationFormService 
{
    constructor(self) 
    {
        this.self = self;
    }


    static submit(x)
    {
		axios.defaults.headers.common['Authorization'] = "";
        return axios.post(API_URL + "/reg", x);
    }
}
