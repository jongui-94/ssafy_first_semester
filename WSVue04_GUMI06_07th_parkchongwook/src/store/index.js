import Vue from 'vue'
import Vuex from 'vuex'
import http from '@/util/http-common.js';
Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    books: [],
    book: {}
  },
  getters: {
    books(state) {
      return state.books
    },
    book(state) {
      return state.book
    }
  },
  mutations: {
    setBooks(state, payload) {
      state.books = payload;
    },
    setBook(state, payload) {
      state.book = payload;
    }
  },
  actions: {
    getBooks(context) {
      http
        .get("/book")
        .then(({ data }) => {
          context.commit("setBooks", data);
        })
        .catch(() => {
          alert("에러");
        });
    },
    getBook(context, payload) {
      console.log(payload);
      http
        .get(`book/${payload}`)
        .then(({ data }) => {
          console.log(data);
          context.commit("setBook", data);          
        })
        .catch(() => {
          alert("에러발생 !");
        });
    },
  },
  modules: {
  }
})
