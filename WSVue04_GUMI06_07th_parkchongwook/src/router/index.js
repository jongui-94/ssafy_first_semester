import Vue from 'vue'
import VueRouter from 'vue-router'
import Book from '@/views/Book.vue'
import BookList from '@/components/book/BookList.vue'
import BookCreate from '@/components/book/BookCreate.vue'
import BookView from '@/components/book/BookView.vue'
import BookModify from '@/components/book/BookModify.vue'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'HomeView',
    component: () => import("@/views/HomeView.vue"),
  },
  {
    path: '/book',
    name: 'book',
    component: Book,
    children: [
      {
        path: '',
        name: 'book-list',
        component: BookList,
      },
      {
        path: 'create',
        name: 'book-create',
        component: BookCreate,
      },
      {
        path: 'view/:isbn',
        name: 'book-view',
        component: BookView,
      },
      {
        path: 'modify/:isbn',
        name: 'book-modify',
        component: BookModify,
      },
    ]
  },



]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router