<script>
import OrderService from "./service";
import Order from "./Order.vue";


export default {
    name: "multi-Order",
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
        OrderService.list().then(response => this.items = response.data);
    },
    components: {
    	"Order": Order
    }
}
</script>

<template>
    <div class="multi-Order"> 
      <Order
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :Order="item.id"
          />
    </div>

</template>

<style scoped> 



</style>