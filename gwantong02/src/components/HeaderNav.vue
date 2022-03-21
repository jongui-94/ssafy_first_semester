<template>
    <div>
        <b-navbar toggleable="lg" type="dark" variant="success">
            <b-navbar-brand @click="movePage('/')">
                <img id="logo" src="@/assets/logo.png">
                SSAFY Cafe
            </b-navbar-brand>

            <b-navbar-nav class="ml-auto" v-show="!loginUser.id">
                <b-button size="sm" type ="button" variant="primary" @click="movePage('/login')">로그인</b-button>
                <b-button size="sm" type ="button" variant="warning" @click="movePage('/register')">회원가입</b-button>
            </b-navbar-nav>

            <b-navbar-nav class="ml-auto" v-show="loginUser.id">
                <b-button size="sm" type ="button" variant="primary" @click="movePage('/user-info')">{{ loginUser.name}}</b-button>
                <b-button size="sm" type ="button" variant="warning" @click="logout">로그아웃</b-button>
            </b-navbar-nav>    
        </b-navbar>
    </div>
</template>

<script>
export default {
    name: 'header-nav',
    methods: {
        movePage(url){
            this.$router.push(url)
        },
        logout() {
            this.$store.dispatch('resetLoginUser');
            this.movePage('/');
        }
    },
    computed: {
        loginUser() {
            let loginUser = this.$store.getters.getLoginUser;
            return loginUser;
        }
    }
}
</script>
<style scope>
#logo{
    width: 30px;
    height: 30px;
}

</style>