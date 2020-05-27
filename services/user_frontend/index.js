import Vue from 'vue'
import Vuex from "vuex";
import App from './App.vue'
import VueRouter from 'vue-router'
import router from './router';

Vue.use(Vuex);

const store = new Vuex.Store({
  state: {
    user: {},
    role: "NOT_LOGGED"
  },
  mutations: {
    login: function (state, data) {
      state.user = data.user;
      state.role = data.role;
    }
  },
  getters: {
  }
});


new Vue({
  router,
  el: '#app',
  store,
  render: h => h(App),
}).$mount("#app")


