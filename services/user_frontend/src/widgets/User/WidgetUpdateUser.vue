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
        UserService.get(this.user).then(response => this.data = response.data);
    }
}
</script>

<template>

<div> 
    <div>
	
		<p>
		<input type="text" class="form-control"  v-model="data.firstname" />
		</p>
		
		<p>
		<input type="text" class="form-control"  v-model="data.lastname" />
		</p>
		
		<p>
		<input type="text" class="form-control" v-model="data.mobilePhone" />
		</p>
		
		<p>
		<input type="text" class="form-control"  v-model="data.address" />
		</p>
		
		<p>
		<input type="date" class="form-control" placeholder="birthday" v-model="data.birthday" />
		</p>
		

		<button type="button" class="btn btn-primary btn-lg btn-block" v-on:click="update">Submit</button>
	</div>
</div>

</template>

<style scoped> 



</style>
