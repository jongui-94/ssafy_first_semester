<template>
    <div class="regist">
            <h1 class="underline">SSAFY 도서 정보</h1>
            <div class="regist_form">
                <label for="isbn">도서번호</label>
                <input type="text" id="isbn" name="isbn" v-model="this.book.isbn" readonly/><br/>
                <label for="title">도서명</label>
                <input type="text" id="title" name="title" v-model="this.book.title" ref="title" readonly /><br/>
                <label for="author">저자</label>
                <input type="text" id="author" name="author" v-model="this.book.author" ref="author" readonly /><br/>
                <label for="price">가격</label>
                <input type="text" id="price" name="price" v-model="this.book.price" ref="price" readonly /><br/>
                <label for="content">설정</label><br/>
                <input id="content" name="content" v-model="this.book.content" ref="content" readonly/>
                <button @click="modify">수정</button>
                <button @click="deleteBtn">삭제</button>
                <button @click="moveList">목록</button>
            </div>
        </div>
</template>

<script>
import http from "@/util/http-common"
import { mapGetters } from 'vuex';
export default {
    name: "view-detail",
    computed:{
        ...mapGetters(["book"])
    },

     methods: {
        moveList() {
            this.$router.push({name : 'book-list'});
        },              

        deleteBtn(){
            http
                .delete(`/book/${this.$route.params.isbn}`)
                .then((data)=>{
                    if(data === 'fail'){
                        alert('삭제가 실패했습니다.')
                    }else{
                        alert('삭제가 성공했습니다.')
                    }
                    this.moveList();
                })
        },

        modify(){
            this.$router.push({name : 'book-modify', params: {isbn: this.$route.params.isbn}});
        }
    }
}
</script>
