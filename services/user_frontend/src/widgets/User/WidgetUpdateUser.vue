<script>
import UserService from "./service";

export default {
    name: "WidgetUpdateUser",
    props: ["user"],
    data: function () {
        return {
            data: {}
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
        UserService.get().then(response => this.data = response.data);
    }
}
</script>

<template>

<div> 
    <div>
	
		<p>
		<input type="text" class="form-control" placeholder="First name"  v-model="data.firstName" />
		</p>
		
		<p>
		<input type="text" class="form-control"  placeholder="Last name" v-model="data.lastName" />
		</p>
		
		<p>
		<input type="text" class="form-control" placeholder="Address" v-model="data.adress" />
		</p>
		

		<button type="button" class="btn btn-primary btn-lg btn-block" v-on:click="update">Submit</button>
	</div>
</div>

</template>

<style scoped> 



</style>
