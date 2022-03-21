<template>
    <div class="content">
      <h1>우리 홍길동 회원님은요!!</h1>
    <div>
      <body>
        로그인 할 때 아이디는 hong을 사용합니다.<br/>
        현재 모은 스탬프는 총 25개로 씨앗 3단계입니다.<br/>
        앞으로 7개만 더 모으면 다음 단계입니다!<br/>
      </body>
    </div>
      <div>
            <h2>주문 내역</h2>
            <div>
                <table id="user-info">
                    <colgroup>
                        <col style="width: 15%" />
                        <col style="width: 25%" />
                        <col style="width: 20%" />
                        <col style="width: 15%" />
                        <col style="width: 25%" />
                    </colgroup>
                    <thead>
                        <tr>
                            <th>주문자</th>
                            <th>날짜</th>
                            <th>스탬프 적립</th>
                            <th>결제 방식</th>
                            <th>총 비용</th>
                        </tr>
                    </thead>
                    <tbody>
                        <list-row
                            v-for="(book, index) in books"
                            :key="index"
                            :no="`${index+1}`"
                            :isbn="book.isbn"
                            :title="book.title"
                            :author="book.author"
                            :price="book.price"
                            />
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</template>

<script>
export default {
  name: 'user-info',
  methods: {

  },
  computed: {
    
  }

}
</script>