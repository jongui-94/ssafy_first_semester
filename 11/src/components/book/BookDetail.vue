<template>
    <div class="regist">
      <h1 class="underline">SSAFY 도서 정보</h1>
      <div class="regist_form">
        <label for="isbn">도서번호</label>
        <input type="text" id="isbn" name="isbn" v-model="book.isbn" ref="isbn" disabled /><br />
        <label for="title">도서명</label>
        <input type="text" id="title" name="title" v-model="book.title" ref="title" disabled /><br />
        <label for="author">저자</label>
        <input type="text" id="author" name="author" v-model="book.author" ref="author" disabled /><br />
        <label for="price">가격</label>
        <input type="number" id="price" name="price" v-model="book.price" ref="price" disabled /><br />
        <label for="content">설명</label>
        <br />
        <textarea type="content" id="content" name="content" v-model="book.content" ref="content" cols="35" rows="5"
          disabled></textarea><br />
        <button @click="moveModify">수정</button>
        <button @click="deleteBook">삭제</button>
        <button @click="moveList">목록</button>
      </div>
    </div>
</template>

<script>
import http from '@/util/http-common'

export default {

    name: 'BookDetail',
    data() {
        return {
            book: {}, 
            newBook: {}};
    },
    created() {
        http
        .get(`/book/${this.$route.params.isbn}`)
        .then((response) => {
            this.book = response.data
        })
        .catch((error) => {
            console.dir(error)
        })
        },
    methods: {
        moveModify() {
            this.$router.replace({name:'book-modify', params : { isbn : `${this.book.isbn}`} } )
        },
        moveList() {
            this.$router.replace({name:'book-list'})
        },
        deleteBook() {
            http
            .delete(`/book/${this.book.isbn}`)
            .then(() => {
                alert("삭제가 완료되었습니다.");
            this.moveList()
            })
            .catch((error) => {
                console.dir(error)
            })
        }
    }
}
</script>
