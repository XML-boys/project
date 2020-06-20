<script>


// import widgets for this view here
import WidgetUpdateUser from "../widgets/User/WidgetUpdateUser.vue"
import WidgetUpdatePassword from "../widgets/User/WidgetUpdatePassword.vue"


export default {
    name: "UpdateProfile",
    data: function () {
            return {
		data: {},
		role: localStorage.getItem("role"),
		client: localStorage.getItem("clientId"),
		user: localStorage.getItem("userId")
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
	WidgetUpdateUser,
	WidgetUpdatePassword
    }
}
</script>

<template>
<div class="profile-update">
<p>Update for user: {{ user.id }}</p>
<WidgetUpdateUser v-if="this.role != 'PATIENT' && this.role != 'NOT_LOGGED'" :user="this.client"/>
<WidgetUpdatePassword v-if="this.role != 'PATIENT'" :user="this.user" />
</div>
</template>

<style scoped> 



</style>
