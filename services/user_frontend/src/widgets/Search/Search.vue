<script>
import SearchService from "./service";

export default {
    name: "Search",
    data: function () {
        return {
            data: {
	    },

        };
    },
    methods: {
    	submit: function() 
	{
		SearchService.submit(this.data).then(response => {
			if (response.data.code == 0) this.data.success = true;
			else this.data.success = false;

		});
	}
    }
}
</script>

<template>
    <div class="form-Search"> 
        <div class="success-box" v-if="success">success</div>
	<div v-if="!success"> 
		
		
		<p>
		<input type="text" class="form-control" placeholder="Name of vehicle contains" v-model="data.name_contains" />
		</p>
		

		<button type="button" class="btn btn-primary btn-lg btn-block" v-on:click="submit">Submit</button>
	</div>
    </div>

</template>

<style scoped> 

.form-Search {

}

.success-box 
{
	backgrund-color: #dfd;
	color: #0f0;
	padding: 5px;
}

</style>