<script>
import AdService from "./service";
import Ad from "./Ad.vue";


export default {
    name: "multi-Ad",
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
        AdService.list().then(response => this.items = response.data);
    },
    components: {
    	"Ad": Ad
    }
}
</script>

<template>
    <div class="multi-Ad"> 
      <Ad
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :Ad="item.id"
          />
    </div>

</template>

<style scoped> 



</style>