<script>


// import widgets for this view here
import RegistrationForm from "../widgets/RegistrationForm/RegistrationForm.vue"

export default {
    name: "Registration",
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
    	"RegistrationForm": RegistrationForm
    }
}
</script>

<template>

<RegistrationForm />

</template>

<style scoped> 



</style>
