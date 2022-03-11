export default {
    template: `
    <div class="regist">
                <h1 class="underline">SSAFY 도서 정보</h1>
                <div class="regist_form">
                    <label for="isbn">도서번호</label>
                    <input type="text" id="isbn" name="isbn" v-model="isbn" ref="isbn"  /> <br>
                    <label for="title">도서명</label>
                    <input type="text" id="title" name="title" v-model="title" ref="title" /><br>
                    <label for="author">저자</label>
                    <input type="text" id="author" name="author" v-model="author" ref="author" /><br>
                    <label for="price">가격</label>
                    <input type="number" id="price" name="price" v-model="price" ref="price" /><br>
                    <label for="content">설명</label>
                    <br>
                    <textarea id="content" name="content" v-model="content" ref="content" cols="35" rows="5"></textarea><br>
                    <button @click="moveModify">수정</button>
                    <button @click="check1">삭제</button>
                    <button @click="moveList">목록</button>
                </div>
            </div>`,
            data() {
                return {
                    isbn: '',
                    title: '',
                    author: '',
                    price: '',
                    content: '',
                    book: {}
                };
            },
            created() {
                const params = new URL(document.location).searchParams;

                let isbn = params.get('isbn');
                // 위 isbn 변수를 사용해서 책 한권 가져오기
                const bookList = JSON.parse(localStorage.getItem("bookList"));
                let nowbook;
                
                for(let book of bookList.books){
                    if(isbn == book.isbn){
                        nowbook = book;
                        break;
                    }
                }
                
                this.isbn = nowbook.isbn;
                this.title = nowbook.title;
                this.author = nowbook.author;
                this.price = nowbook.price;
                this.content = nowbook.content;

            },
            methods: {
                check1() {
                    let err = false;
                    let msg = '';
                    if (!this.isbn) {
                        msg = "isbn 입력해주세요 !!!";
                        err = true;
                        this.$refs.isbn.focus();
                    }
                    else if (!this.title) {
                        msg = "title 입력해주세요 !!!";
                        err = true;
                        this.$refs.title.focus();
                    }
                    else if (!this.author) {
                        msg = "author 입력해주세요 !!!";
                        err = true;
                        this.$refs.author.focus();
                    }
                    else if (!this.price) {
                        msg = "price 입력해주세요 !!!";
                        err = true;
                        this.$refs.price.focus();
                    }
                    else if (!this.content) {
                        msg = "content 입력해주세요 !!!";
                        err = true;
                        this.$refs.content.focus();
                    }
                    // TODO: 나머지 항목은 여러분이 작성하기
                    if (err) {
                        alert(msg);
                    }
                    else {
                        // 입력한 도서 수정하기
                        this.deleteBook();
                    }
                },
                deleteBook() {
                    const params = new URL(document.location).searchParams;

                    let isbn = params.get('isbn');
                    // 위 isbn 변수를 사용해서 책 한권 가져오기
                    const bookList = JSON.parse(localStorage.getItem("bookList"));
                    let idx = 0;
                    for(let book of bookList.books){
                        if(this.isbn === book.isbn){
                            break;
                        }
                        idx = idx +1;
                    }
                    bookList.books.splice(idx,1);
                    localStorage.setItem("bookList", JSON.stringify(bookList));
                    alert("삭제가 완료되었습니다.");
                    location.href = "list.html";
                },

                moveModify() {
                    location.href = "./modify.html?isbn=" + this.isbn;
                },

                moveList() {
                    location.href = "list.html";
                }
            }
};