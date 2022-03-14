<template>
    
    <div>
<h1 class="underline">도서 목록</h1>
<div style="text-align: right">
    <button @click="movePage">도서 등록</button>
</div>
<div v-if="books.length">
    <table id="book-list">
        <colgroup>
            <col style="width: 5%" />
            <col style="width: 20%" />
            <col style="width: 40%" />
            <col style="width: 20%" />
            <col style="width: 15%" />
        </colgroup>
        <thead>
            <tr>
                <th>번호</th>
                <th>ISBN</th>
                <th>제목</th>
                <th>저자</th>
                <th>가격</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(book, index) in books" :key="index">
                <td>{{ index + 1 }}</td>
                <td>{{ book.isbn }}</td>
                <td>
                    <router-link :to="{name: 'book-detail', params: {isbn: book.isbn}} ">
                        {{ book.title }}
                    </router-link>
                </td>
                <td>{{ book.author }}</td>
                <td>{{ book.price | priceFilter }}</td>
            </tr>
        </tbody>
    </table>
</div>
<div v-else class="text-center">게시글이 없습니다.</div>
</div>

</template>

<script>
import http from '@/util/http-common.js'            // axios를 통신 임포트
export default {            //router에서 import할 수 있도록 export하는 부분

    data() {
        return {
            books: []
        };
    },
    created() {             // 페이지가 실행될때 실행되는 메서드
       http                 // axios사용하기위해서
        .get('/book')       // 모든책의정보를 반환한다.
        .then(({data})=>{   // 받아온 데이터를 books에저장한다
            this.books=data;
        })
        .catch(()=>{        // 에러발생시 
            alert("북리스트 에러");
        })     
    },
    methods: {
        movePage() {
            this.$router.push({name:'book-create'});
}
    }
}
</script>
