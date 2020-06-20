<script>


// import widgets for this view here

import Ads from "../widgets/Ad/multi-Ad.vue";

export default {
    name: "Login",
    data: function () {
            return {
		data: {}
	    };
	},
    mounted: function () 
    {
    },
    methods: {
        submit: function (event) 
        {
            
        }
    },
    components: {
        Ads
    }
}
</script>

<template>
<div>
<p>Ads</p>

<Ads></Ads>
</div>
</template>

<style scoped> 



</style>
