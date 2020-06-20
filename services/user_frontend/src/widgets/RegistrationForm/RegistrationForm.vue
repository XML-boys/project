<script>
import RegistrationFormService from "./service";

export default {
    name: "RegistrationForm",
    data: function () {
        return {
            data: {
				username: "",
				email: "",
				password: "",
				role: "Client",
	    },

        };
    },
    methods: {
    	submit: function() 
	{
		if(this.data.password === this.data.password2){
				RegistrationFormService.submit(this.data).then(response => {
					if (response.status < 300) window.location.href = "/frontend/";
				});
		
		}else{
			alert("Passwords don't match");
		}
	}
    }
}
</script>

<template>
    <div class="form-RegistrationForm"> 
        <div class="success-box" ></div>
		
		<h2>Registration</h2>
		
		<p>
		<input type="text" class="form-control" placeholder="Username" v-model="data.username" />
		</p>
		
		<p>
		<input type="text" class="form-control" placeholder="E-Mail" v-model="data.email" />
		</p>
		
		<p>
		<input type="password" class="form-control" placeholder="Password" v-model="data.password" />
		</p>

		<p>
		<input type="password" class="form-control" placeholder="Repeat password" v-model="data.password2" />
		</p>
		

		<button type="button" class="btn btn-primary btn-lg btn-block" v-on:click="submit">Submit</button>
		&nbsp;
		&nbsp;
		<a href="/frontend/#/login">If you already have account, click here to login</a>
		
	</div>
    

</template>

<style scoped> 

.form-RegistrationForm {
	position: relative;
    top:10%;
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
