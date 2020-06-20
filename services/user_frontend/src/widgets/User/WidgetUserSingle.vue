<script>
import UserService from "./service";

export default {
    name: "WidgetUserSingle",
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function()
    {
        UserService.get().then(response => {
            console.log(response);
            this.data = response.data;
        });
    }
}
</script>

<template>
    <div class="widget-user-single"> 


<div  >
  <div >
    <h5 >User: {{ data.firstName }} {{ data.lastName }}</h5>
    <p >Address: {{ data.adress}}</p>
  </div>
</div>

    </div>

</template>

<style scoped> 



</style>
