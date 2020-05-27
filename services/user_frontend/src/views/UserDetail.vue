<script>



import UserService from "../widgets/User/service"
import WidgetUserSingle from "../widgets/User/WidgetUserSingle.vue"
import WidgetUserSingleEdit from "../widgets/User/WidgetUserSingleEdit.vue"
import WidgetUserMulti from "../widgets/User/WidgetUserMulti.vue"
import WidgetUserNew from "../widgets/User/WidgetUserNew.vue"


export default {
    name: "UserDetail",
    props: ["user"],
    data: function () {
            return {
		data: {},
		user: localStorage.getItem("user_id")
	    };
	},
    mounted: function () 
    {
    	UserService.get(this.user).then(response => this.data = response.data)
    },
    methods: {
    },
    components: {
        "WidgetUserSingle": WidgetUserSingle,
        "WidgetUserNew": WidgetUserNew,
        "WidgetUserSingleEdit": WidgetUserSingleEdit,
        "WidgetUserMulti": WidgetUserMulti
    }
}
</script>

<template>
    <div class="User-detail"> 
        <button v-on:click="itemDelete">Delete</button>
        <WidgetUserSingle :user="this.user" />
    </div>

</template>

<style scoped> 



</style>
