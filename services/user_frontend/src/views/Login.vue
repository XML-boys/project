<script>


// import widgets for this view here
import WidgetLoginNew from "../widgets/Auth/WidgetLoginNew.vue"

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
    	"WidgetLoginNew": WidgetLoginNew
    }
}
</script>

<template>
<div >
<WidgetLoginNew />
</div>

</template>

<style scoped> 


</style>
