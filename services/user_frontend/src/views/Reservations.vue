<script>


// import widgets for this view here

import Reservations from "../widgets/Order/multi-Order.vue";

export default {
    name: "ReservationsPage",
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
        Reservations
    }
}
</script>

<template>
<div>
<p>Reservations</p>

<Reservations :filter="reservation => reservation.userId == localStorage.getItem('userId')" />

</div>
</template>

<style scoped> 



</style>
