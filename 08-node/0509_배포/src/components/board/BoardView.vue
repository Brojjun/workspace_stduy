<template>
  <div class="regist">
    <h1 class="underline">SSAFY 글 상세보기</h1>
    <div class="regist_form">
      <label> 글번호</label>
      <div class="view">글번호</div>
      <label> 글제목</label>
      <div class="view">제목</div>
      <label> 작성자</label>
      <div class="view">작성자</div>
      <label> 조회수</label>
      <div class="view">조회수</div>
      <label> 작성시간</label>
      <div class="view">작성시간</div>
      <label> 내용</label>
      <div class="view">내용</div>

      <div style="padding-top: 15px">
        <a href="" class="btn">수정</a>
        <a href="" class="btn">삭제</a>
        <a href="" class="btn">목록</a>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "BoardView",
  data() {
    return {
      
    };
  },
  created() {
    // 비동기
    // TODO : 글번호에 해당하는 글정보 얻기.
  },
};
</script>

<style></style>
