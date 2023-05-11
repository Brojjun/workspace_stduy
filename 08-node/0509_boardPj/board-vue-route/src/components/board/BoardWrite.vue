<template>
  <div class="regist">
    <h1 class="underline">SSAFY 게시글 작성</h1>
    <div class="regist_form">
      <label for="userid">작성자</label>
      <input type="text" id="userid" ref="userid" v-model="userNo" /><br />
      <label for="subject">제목</label>
      <input type="text" id="subject" ref="subject" v-model="title" /><br />
      <label for="content">내용</label>
      <br />
      <textarea id="content" ref="content" cols="35" rows="5" v-model="contents"></textarea><br />
      <button @click="checkValue">등록</button>
      <button @click="moveList">목록</button>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: "BoardWrite",
  data() {
    return {
      title:"",
      contents:"",
      userNo:"",
    };
  },
  methods: {
    // 입력값 체크하기 - 체크가 성공하면 registArticle 호출
    checkValue() {
      // 사용자 입력값 체크하기
      // 작성자아이디, 제목, 내용이 없을 경우 각 항목에 맞는 메세지를 출력
      let err = true;
      let msg = "";
      !this.userNo && ((msg = "작성자 입력해주세요"), (err = false), this.$refs.userid.focus());
      err && !this.title && ((msg = "제목 입력해주세요"), (err = false), this.$refs.subject.focus());
      err && !this.contents && ((msg = "내용 입력해주세요"), (err = false), this.$refs.content.focus());

      if (!err) alert(msg);
      // 만약, 내용이 다 입력되어 있다면 registArticle 호출
      else this.registArticle();
    },
    registArticle() {
      let header={
        headers:{
          "Content-Type" : "application/json"
        }
      }
      let body={
        title:this.title,
        contents:this.contents,
        userNo:this.userNo,
      }
      axios.post("http://localhost/api/notice/write",body,header)
      .catch(response=>{console.log(response)});

      // fetch("http://localhost/api/notice/write",{
      //   method:"POST",
      //   headers:{
      //     "Content-Type" : "application/json",
      //   },
      //   body:JSON.stringify({
      //     title:this.title,
      //     contents:this.contents,
      //     userNo:this.userNo,
      //   }),
      // })
      this.title="";
      this.contents="";
      this.userNo="";
    },

    moveList() {
      console.log("글목록 보러가자!!!");
    },
  },
};
</script>

<style></style>
  

