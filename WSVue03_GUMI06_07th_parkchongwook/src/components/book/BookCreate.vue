<template>
            <div class="regist">
            <h1 class="underline">SSAFY 도서 등록</h1>
            <div class="regist_form">
                <label for="isbn">도서번호</label>
                <input type="text" id="isbn" name="isbn" v-model="isbn" ref="isbn"/><br/>
                <label for="title">도서명</label>
                <input type="text" id="title" name="title" v-model="title" ref="title"/><br/>
                <label for="author">저자</label>
                <input type="text" id="author" name="author" v-model="author" ref="author"/><br/>
                <label for="price">가격</label>
                <input type="text" id="price" name="price" v-model="price" ref="price"/><br/>
                <label for="content">설정</label><br/>
                <textarea id="content" name="content" v-model="content" ref="content" cols="35" rows="5"></textarea>
                <button @click="checkValue">등록</button>
                <button @click="moveList">목록</button>
            </div>
        </div>  

</template>
<script>
import http from "@/util/http-common.js"
export default{
     data(){
        return{
            isbn: '',
            title: '',
            author: '',
            price: '',
            content: ''
        };
    },
    methods: {
        checkValue(){
            let err = false;
            let msg = '';

            if(!this.isbn){
                msg = "isbn을 입력해 주세요";
                err = true;
                this.$refs.isbn.focus();
            }
            else if(!this.title){
                msg = "제목을 입력해 주세요";
                err = true;
                this.$refs.title.focus();
            }
            else if(!this.author){
                msg = "작가를 입력해 주세요";
                err = true;
                this.$refs.author.focus();
            }
            else if(!this.price){
                msg = "가격을 입력해 주세요";
                err = true;
                this.$refs.price.focus();
            }

            if(err){
                alert(msg);
            }
            else{
                //입력한 도서 등록하기
                this.registBook();
            }
        },

        registBook(){
            http
                .post('/book', {
                    isbn: this.isbn,
                    title: this.title,
                    author: this.author,
                    price: this.price,
                    content: this.content
                })
                .then(( data ) =>{
                    if(data === 'fail'){
                        alert('등록 실패했습니다.')
                    }else{
                        alert('등록 성공했습니다.')
                    }
                    this.moveList();
                })
                .catch(()=>{
                    alert('등록 실패했습니다.');
                })
        },
        moveList() {
            this.$router.push({name : 'book-list'});
        }
    }
}

</script>
