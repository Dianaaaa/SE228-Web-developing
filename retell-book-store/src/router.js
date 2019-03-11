import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import ViewBooks from './views/ViewBooks'
import BookDetail from './views/BookDetail'

Vue.use(Router)

export default new Router({
    mode: 'history',
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/view',
      name: 'viewbooks',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: ViewBooks
    },
      {
        path: '/detail',
          name: 'bookdetail',
          component: BookDetail
      }
  ]
})
