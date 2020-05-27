<script>
import LoginService from "./service";
import CheckRoleService from "../CheckRole/service";
//import router from '../../../router';

export default {
    name: "WidgetLoginNew",
    data: function () {
        return {
            data: {
	    	email: null,
		password: null,
	    },

        };
    },
    methods: {
    	submit: function() 
	{
		LoginService.login(this.data).then(response => {
			console.log(response)
			if (response.status == 200) {
				CheckRoleService.get().then(response => {
					this.data.success = true;
					localStorage.setItem("user", this.data.email);
					localStorage.setItem("role", response.data);
					this.$store.commit("login", {user: this.data.email, role: response.data});
					CheckRoleService.info().then(x => {
						console.log("User info")
						console.log(x.data);
						localStorage.setItem("user_id", x.data.id);
						if (x.data.numberOfLogins <= 1 && response.data != "PATIENT") 
						{
							this.$router.push("/updateUser");
						}
						else this.$router.push("/");
					});


				});

			}
			else {
				this.data.success = false;
				localStorage.setItem("user", null);
				alert("Error while logging in. Access forbidden or wrong credentials");
			}


		}).catch(error => {
				alert("Error while logging in. Access forbidden or wrong credentials");
		});
	}
    }
}
</script>

<template>

    <div class="widget-login-new"> 

		<h2> Login</h2>
		<p>
		<input type="email" class="form-control" placeholder="Username" v-model="data.email" />
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
