<script>
import AdService from "./service";
import Vehicle from "../Vehicle/Vehicle.vue";

export default {
    name: "Ad",
    props: ["Ad"],
    data: function () {
        return {
            data: {},
        }
    },
    mounted: function () 
    {
        AdService.get(this.Ad).then(response => this.data = response.data);
    },
    methods: 
    {
    	deleteItem: function() 
	{
		AdService.delete(this.Ad).then(response => this.data = {});
	}
	// add additional methods here
    },
    components: {
        Vehicle
    }
}
</script>

<template>
    <div class="widget-Ad"> 
    <span class="badge badge-pill badge-info">Ad: </span>

    <div class="card" style="width: 18rem;">
      <p>{{data.id}}</p>
      <div class="card-body">
        <h5 class="card-title">{{ data.location }} </h5>
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

    <Vehicle :Vehicle="this.data.vehicleId" />
    </div>

</template>

<style scoped> 



</style>