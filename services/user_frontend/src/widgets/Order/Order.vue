<script>
import OrderService from "./service";
import Ad from "../Ad/Ad.vue";

export default {
    name: "Order",
    props: ["Order"],
    data: function () {
        return {
            data: {},
        }
    },
    mounted: function () 
    {
        OrderService.get(this.Order).then(response => this.data = response.data);
    },
    methods: 
    {
    	deleteItem: function() 
	{
		OrderService.delete(this.Order).then(response => this.data = {});
	}
	// add additional methods here
    },
    components: {
    	Ad
    }
}
</script>

<template>
    <div class="widget-Order"> 
    <span class="badge badge-pill badge-info">Order: </span>

    <div class="card" style="width: 18rem;">
      <div class="card-body">
        <h5 class="card-title">Reservation for: {{ data.startTime }} - {{ data.endTime }}</h5>
        <p class="card-text item-description"></p>
      </div>

    
    <div class="card-body">
    </div>
    </div>
    <Ad :Ad="this.data.reklama.id" />
    </div>

</template>

<style scoped> 



</style>
