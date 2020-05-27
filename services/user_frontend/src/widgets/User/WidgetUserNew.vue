<script>
import UserService from "./service";

export default {
    name: "WidgetUserNew",
    data: function () {
        return {
            data: {
	    	username: null,
		password: null,
		email: null
	    },
	    success: false
        };
    },
    methods: {
    	submit: function() 
	{
		UserService.create(this.data).then(response => this.success = true);
	}
    }
}
</script>

<template>
    <div class="widget-user-new"> 
        <div v-if="success">Creation successful</div>
	<div v-if="!success"> 
		<p>
		<label>Username</label>
		<input type="text" v-model="data.username" />
		</p>
		
		<p>
		<label>Password</label>
		<input type="text" v-model="data.password" />
		</p>
		
		<p>
		<label>Email</label>
		<input type="text" v-model="data.email" />
		</p>
		
		<p>
		<label>Firstname</label>
		<input type="text" v-model="data.firstname" />
		</p>
		
		<p>
		<label>Lastname</label>
		<input type="text" v-model="data.lastname" />
		</p>
		
		<p>
		<label>Phone</label>
		<input type="text" v-model="data.phone" />
		</p>

		<p><button v-on:click="submit">Submit</button></p>
	</div>
    </div>

</template>

<style scoped> 



</style>
