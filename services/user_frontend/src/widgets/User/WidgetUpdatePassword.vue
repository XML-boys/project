<script>
import UserService from "./service";

export default {
    name: "WidgetUpdateUser",
    props: ["user"],
    data: function () {
        return {
            data: {},
	    retyped_password: ""
        }
    },
    methods: {
    	update: function() 
		{
			UserService.update(this.data).then(response => {
				window.location.href = "/frontend/#/profile";
			});
		}
	},
    mounted: function()
    {
        UserService.get(this.user).then(response => {
		this.data = response.data
		this.data.password = "";
	});
    }
}
</script>

<template>

<div> 
    <div>
	
		<p>
		<input type="password" class="form-control"  v-model="data.password" placeholder="New password"/>
		<input type="password" class="form-control"  v-model="retyped_password" placeholder="Retype New password"/>
		</p>
		

		<button v-if="this.data.password == this.retyped_password && this.data.password.length > 5" type="button" class="btn btn-primary btn-lg btn-block" v-on:click="update">Submit</button>
	</div>
</div>

</template>

<style scoped> 



</style>
