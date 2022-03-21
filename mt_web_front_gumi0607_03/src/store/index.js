import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    user: {
      id: '',
      name: '',
      pass: '',
      stamps: 0
    },
    loginUser: {
      id: '',
      name: '',
      pass: '',
      stamps: 0
    },
    products: []
  },
  getters: {
    getUser(state) {
      return state.user;
    },
    getLoginUser(state) {
      return state.loginUser;
    },
    getProducts(state) {
      return state.products;
    }
  },
  mutations: {
    INSERT_USER(state, user) {
      state.user.id = user.id;
      state.user.name = user.name;
      state.user.pass = user.pass;
      state.user.stamps = user.stamps;
    },
    LOGIN_USER(state, loginUser) {
      state.loginUser.id = loginUser.id;
      state.loginUser.name = loginUser.name;
      state.loginUser.pass = loginUser.pass;
      state.loginUser.stamps = loginUser.stamps;
    },
    SELECT_PRODUCT(state, products) {
      state.products = products;
    }
  },
  actions: {
    insertUser({ commit }, user) {
      // TODO: 아래 코드는 서버 대신 작성한 코드이므로 추후 삭제
      let t_user_string = localStorage.getItem('t_user');
      let t_user = JSON.parse(t_user_string);

      for (let u of t_user) {
        if (u.id === user.id) {
          user.id = '';
          user.name = '';
          user.pass = '';
          commit('INSERT_USER', user);
          return;
        }
      }

      // 새로 입력한 사용자 정보 localStorage에 추가
      t_user.push(user);
      localStorage.setItem('t_user', JSON.stringify(t_user));

      commit('INSERT_USER', user);
    },
    login({ commit }, user) {
      // TODO: 아래 코드는 서버 대신 작성한 코드이므로 추후 삭제
      let t_user_string = localStorage.getItem('t_user');
      let t_user = JSON.parse(t_user_string);

      let loginUser = {};
      for (let u of t_user) {
        if (u.id === user.id && u.pass === user.pass) {
          loginUser = u;
          break;
        }
      }

      // localStorage에서 일치한 사용자 혹은 빈 값을 전달
      commit('LOGIN_USER', loginUser);
    },
    resetLoginUser({ commit }) {
      commit('LOGIN_USER', {
        id: '',
        name: '',
        pass: '',
        stamps: 0
      });
    },
    selectProducts({ commit }) {
      // TODO: 아래 코드는 서버 대신 작성한 코드이므로 추후 삭제
      let t_product_string = localStorage.getItem('t_product');
      let t_product = JSON.parse(t_product_string);

      // localStorage에서 가져온 상품 정보 전달
      commit('SELECT_PRODUCT', t_product);
    }
  },
  modules: {
  }
})
