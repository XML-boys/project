<script>
import VehicleService from "./service";
import Vehicle from "./Vehicle.vue";


export default {
    name: "multi-Vehicle",
    props: {
        filter: {
            type: Function,
            default: (x => true)
        }
    },
    data: function () {
        return {
            items: []
        }
    },
    mounted: function () 
    {
        VehicleService.list().then(response => this.items = response.data);
    },
    components: {
    	"Vehicle": Vehicle
    }
}
</script>

<template>
    <div class="multi-Vehicle"> 
      <Vehicle
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :Vehicle="item.id"
          />
    </div>

</template>

<style scoped> 



</style>