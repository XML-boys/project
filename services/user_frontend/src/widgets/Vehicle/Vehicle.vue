<script>
import VehicleService from "./service";

export default {
    name: "Vehicle",
    props: ["Vehicle"],
    data: function () {
        return {
            data: {},
        }
    },
    mounted: function () 
    {
        VehicleService.get(this.Vehicle).then(response => this.data = response.data);
    },
    methods: 
    {
    	deleteItem: function() 
	{
		VehicleService.delete(this.Vehicle).then(response => this.data = {});
	}
	// add additional methods here
    }
}
</script>

<template>
    <div class="widget-Vehicle"> 
    <span class="badge badge-pill badge-info">Vehicle: </span>

    <div class="card" style="width: 18rem;">
      <p>Vehicle</p>
      <div class="card-body">
        <h5 class="card-title">{{ data.vendor}} {{ data.model}}</h5>
        <p class="card-text item-description"></p>
      </div>

    
     <ul class="list-group list-group-flush">
        <li class="list-group-item"></li>
     </ul>


    <div class="card-body">
    </div>
    </div>
    </div>

</template>

<style scoped> 



</style>