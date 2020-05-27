<script>
import AgentService from "./service";

export default {
    name: "Agent",
    props: ["Agent"],
    data: function () {
        return {
            data: {},
        }
    },
    mounted: function () 
    {
        AgentService.get(this.Agent).then(response => this.data = response.data);
    },
    methods: 
    {
    	deleteItem: function() 
	{
		AgentService.delete(this.Agent).then(response => this.data = {});
	}
	// add additional methods here
    }
}
</script>

<template>
    <div class="widget-Agent"> 
    <span class="badge badge-pill badge-info">Agent: </span>

    <div class="card" style="width: 18rem;">
      <p>TOP</p>
      <div class="card-body">
        <h5 class="card-title"></h5>
        <p class="card-text item-description"></p>
      </div>

    
     <ul class="list-group list-group-flush">
        <li class="list-group-item"></li>
     </ul>


    <div class="card-body">
      <button class="btn btn-danger" @click="deleteItem" v-if="true">Delete</button>
      <button class="btn btn-primary" @click="orderItem" v-if="true">Button</button>
    </div>
    </div>
    </div>

</template>

<style scoped> 



</style>