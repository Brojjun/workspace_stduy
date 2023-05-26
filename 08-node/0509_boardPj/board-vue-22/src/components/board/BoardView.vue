<template>
  <div class="regist">
    <h1 class="underline">SSAFY 글 상세보기</h1>
    <div class="regist_form">
      <label> 글번호</label>
      <div class="view">{{ this.$route.params.no }}</div>
      <label> 글제목</label>
      <div class="view">{{ notice.title }}</div>
      <label> 작성자</label>
      <div class="view">{{ notice.writerName }}</div>
      <label> 조회수</label>
      <div class="view">{{ notice.hits }}</div>
      <label> 작성시간</label>
      <div class="view">{{ notice.registDate }}</div>
      <label> 내용</label>
      <div class="view">{{ notice.contents }}</div>

      <div style="padding-top: 15px">
        <a href="" class="btn">수정</a>
        <a href="" class="btn">삭제</a>
        <a href="" class="btn">목록</a>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: "BoardView",
  data() {
    return {
      notice:{},
    };
  },
  created() {
    console.dir(
      "http://localhost/api/notice/info/"+this.$route.params.no);
    axios.get("http://localhost/api/notice/info/"+this.$route.params.no)
    .then(response=>{
      console.dir(response.data);
      this.notice = response.data;
    })
  },
};
</script>

<style></style>
