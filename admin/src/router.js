import Vue from 'vue'
import Router from 'vue-router'
import Login from './views/login'
import Admin from './views/admin'
import Welcome from "./views/admin/welcome"
import Chapter from "./views/admin/chapter"
import axios from "axios"
Vue.use(Router);
Vue.prototype.$ajax = axios;

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [{
    path: "*",
    redirect: "/login",
  }, {
    path: "",
    redirect: "/login",
  }, {
    path: "/login",
    component: Login
  }, {
    path: "/",
    name: "admin",
    component: Admin,
    children: [
      {
        // 子路由不需要斜杠
        path: "welcome",
        name: "welcome",
        component: Welcome,
      },
      {
        path: "business/chapter",
        name: "business/chapter",
        component: Chapter
      }
    ]
  }]
})