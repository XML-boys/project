<script>
import AdService from "./service";
import Vehicle from "../Vehicle/Vehicle.vue";

export default {
    name: "Ad",
    props: ["Ad"],
    data: function () {
        return {
            data: {},
            showOrder: true
        }
    },
    mounted: function () 
    {
        AdService.get(this.Ad).then(response => this.data = response.data);
    },
    methods: 
    {
    	orderItem: function() 
	{
		AdService.order(this.data).then(response => this.showOrder = false);
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
        <p class="card-text item-description">Available from: {{ data.startTime}}</p>
        <p class="card-text item-description">Available until: {{ data.endDate}}</p>
        <p class="card-text item-description">Price: {{ data.cena}}</p>
        <img v-for="kurconjero in this.data.pictures" :id="kurconjero" key="kurconjero" :src="kurconjero" />
      </div>

    
     <ul class="list-group list-group-flush">
        <li class="list-group-item">Damage {{ data.damage}}</li>
     </ul>

    <div class="card-body">
      <button class="btn btn-primary" @click="orderItem" v-if="this.orderItem">Make order</button>
    </div>
    </div>

    <Vehicle v-if="this.data.vehicleId != undefined" :Vehicle="this.data.vehicleId" />
    </div>

</template>

<style scoped> 

.widget-Ad {
    background-color: #ddffff;
    padding: 5px;
    margin: 50px;
}

</style>