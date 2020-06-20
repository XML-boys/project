<script>
import LoginService from "./service";
import CheckRoleService from "../CheckRole/service";
import axios from "axios"

//import router from '../../../router';

export default {
    name: "WidgetLoginNew",
    data: function () {
        return {
            data: {
	    	username: null,
			password: null,
			role: "Client"
	    },

        };
    },
    methods: {
    	submit: function() 
	{
		LoginService.login(this.data).then(response => {
			console.log(response)
			axios.defaults.headers.common['Authorization'] = response.data.jwttoken;
			LoginService.getProfile().then(response => {
				console.log(response);
				localStorage.setItem("username", this.data.username);;
				localStorage.setItem("user", this.data.username);;
				localStorage.setItem("email", this.data.email);;
				localStorage.setItem("clientId", this.data.id);;
				localStorage.setItem("userId", this.data.userId);;
				localStorage.setItem("role", "LOGGED");;
				window.location.href = "/frontend/";
			})
			

			
		}
		)
		.catch(error => {
				alert("ERROR while logging in. Access forbidden or wrong credentials");
		});
	}
    }
}
</script>

<template>

    <div class="widget-login-new"> 

		<h2> Login</h2>
		<p>
		<input type="text" class="form-control" placeholder="Username" v-model="data.username" />
		</p>
		
		<p>
		<input type="password" class="form-control" placeholder="Password" v-model="data.password" />
		</p>
		

		<button type="button" class="btn btn-primary btn-lg btn-block" v-on:click="submit">Submit</button>
		&nbsp;
		&nbsp;
		<a href="/frontend/#/register">If you dont have account, click here to register</a>
    </div>

</template>

<style scoped> 



.widget-login-new {
	position: relative;
    top:20%;
    left:40%;
	padding: 10px; 
	margin: 10px;
	text-align: center;
	width: 20%;
}

.success-box 
{
	
	padding: 5px;
}

</style>
