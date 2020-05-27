<script>
import UserService from "./service";

export default {
    name: "WidgetUserSingle",
    props: ["user"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function()
    {
        UserService.get(this.user).then(response => this.data = response.data);
    }
}
</script>

<template>
    <div class="widget-user-single"> 


<div  >
  <div >
    <h5 >{{ data.firstname }} {{ data.lastname }}</h5>
    <p >{{ data.email}}</p>
    <p >{{ data.address}}</p>
    <p >{{ data.mobile_phone}}</p>
  </div>
</div>

    </div>

</template>

<style scoped> 



</style>
