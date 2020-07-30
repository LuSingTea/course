import Vue from 'vue'
import App from './app.vue'
import router from "./router";


Vue.config.productionTip = false

/**
 * axios拦截器
 * console.log 可以去掉了
 */
axios.interceptors.request.use(function (config) {
  console.log("请求：", config);
  return config;
}, error => {});

axios.interceptors.response.use(function (response) {
  console.log("返回结果：", response);
  return response;
}, error => {});

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')

console.log("环境:" + process.env.NODE_ENV)
