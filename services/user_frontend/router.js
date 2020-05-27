import routes from './routes';
import Vue from 'vue'
import VueRouter from 'vue-router'


Vue.use(VueRouter)

const router = new VueRouter({routes});
/*router.beforeEach((to, from, next) => {
  if (to.fullPath !== '/login') {
    if (localStorage.getItem("user")) {
      next('/login');
    }
  }
  if (to.fullPath === '/login') {
    if (localStorage.getItem("user")) {
      next('/');
    }
  }
  next();
});
*/
export default router;
