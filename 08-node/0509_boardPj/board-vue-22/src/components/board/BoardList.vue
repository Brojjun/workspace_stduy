<template>
  <div>
    <h1 class="underline">도서 목록</h1>
    <div style="text-align: right">
      <button @click="movePage">도서 등록</button>
    </div>
    <div v-if="articles.length">
      <table id="article-list">
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 65%" />
          <col style="width: 10%" />
          <col style="width: 5%" />
          <col style="width: 15%" />
        </colgroup>
        <thead>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>조회수</th>
            <th>작성일</th>
          </tr>
        </thead>
        <tbody>
          <board-list-item v-for="article in articles" :key="article.articleNo" :article="article"></board-list-item>
        </tbody>
      </table>
    </div>
    <div class="text-center" v-else>게시글이 없습니다.</div>

  </div>
</template>

<script>

import BoardListItem from './BoardListItem.vue';
import axios from 'axios';

export default {
  name: "BoardList",
  components:{
    BoardListItem,
  },
  data() {
    return {
      articles:[],
    };
  },
  created() {
    axios.get("http://localhost/api/notice/list")
    .then(response => {
      console.log(response.data);
      this.articles = response.data;
    })
    .catch(error => {
      console.log(error);
    })
    // fetch("http://localhost/api/notice/list")
    // .then(response=> response.json())
    // .then(data=>{
    //   console.log(data);
    //   this.articles = data;
    // })
      
  },
  methods: {
    movePage() {},
   
  },
};
</script>

<style></style>
