<template>
  <div class="regist">
    <h1>SSAFY 글 삭제</h1>
    <input v-model="num" type="number" />
    <button v-on:click="deleteBoard">삭제</button>

    
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: "BoardDelete",
  data(){
    return{
      num:"0",
    };
  },
  methods:{
    deleteBoard(){
      axios.put(`http://localhost:80/api/notice/delete/${this.num}`)
      .catch(error=>{
        console.log(error);
      })
      ;
      //fetch("http://localhost/api/notice/delete/"+this.num);
      console.dir(this.num)
  
    },
  }
};


</script>

<style></style>
