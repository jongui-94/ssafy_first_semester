<template>
    <div class="regist">
            <h1 class="underline">SSAFY 도서 수정</h1>
            <div class="regist_form">
                <label for="isbn">도서번호</label>
                <input type="text" id="isbn" name="isbn" v-model="isbn" disabled/><br/>
                <label for="title">도서명</label>
                <input type="text" id="title" name="title" v-model="title" ref="title"/><br/>
                <label for="author">저자</label>
                <input type="text" id="author" name="author" v-model="author" ref="author"/><br/>
                <label for="price">가격</label>
                <input type="text" id="price" name="price" v-model="price" ref="price"/><br/>
                <label for="content">설정</label><br/>
                <input id="content" name="content" v-model="content" ref="content"/>
                <button @click="modifyBook">수정</button>                
                <button @click="moveList">목록</button>
            </div>
        </div>
</template>
        
<script>
import http from '@vue/composition-api'
        
        export default defineComponent({
            setup() {
                
            },
        })
        </script>
        
    `
    ,
    data(){
        return{
            isbn: '',
            title: '',
            author: '',
            price: '',
            content: ''
        }
    },

    created() {
        const params = new URL(document.location).searchParams;
        let isbn = params.get('isbn');
        
        // 위  isbn 변수를 사용해서 책 한권 가져오기                
        const bookList = localStorage.getItem("bookList");                
        let books = JSON.parse(bookList);
        let selectBook;
        
        for(var i = 0; i < books.books.length; i++){
            if(books.books[i].isbn == isbn){
                selectBook = books.books[i];
                break;
            }
        }                
        this.isbn = selectBook.isbn;
        this.title = selectBook.title;
        this.author = selectBook.author;
        this.price = selectBook.price;
        this.content = selectBook.content;
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
                //입력한 도서 수정하기
                this.modifyBook();
            }
        },

        modifyBook(){
            const bookList = localStorage.getItem("bookList");

            let modifyBook ={
                books: []
            };

            if(bookList){
                modifyBook = JSON.parse(bookList);
            }

            for(var book of modifyBook.books){
                if(this.isbn === book.isbn){
                    book.title = this.title;
                    book.author = this.author;
                    book.price = this.price;
                    book.content = this.content;
                    break;
                }
            }
            localStorage.setItem("bookList", JSON.stringify(modifyBook));
            alert("수정이 완료되었습니다.");
            location.href = "./list.html";
        },
        moveList(){
            location.href = "./list.html";
        }                
    },
}