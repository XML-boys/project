<script>
import AgentService from "./service";
import Agent from "./Agent.vue";


export default {
    name: "multi-Agent",
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
        AgentService.list().then(response => this.items = response.data);
    },
    components: {
    	"Agent": Agent
    }
}
</script>

<template>
    <div class="multi-Agent"> 
      <Agent
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :Agent="item.id"
          />
    </div>

</template>

<style scoped> 



</style>