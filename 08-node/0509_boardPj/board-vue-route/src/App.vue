<template>
  <div id="app">
    <TheHeaderVue></TheHeaderVue>
  
  </div>
</template>

<script type="module" scr="router/index.js"></script>
<script>
//불러오기
import AppBoardVue from './views/AppBoard.vue';
import TheHeaderVue from './components/TheHeader.vue';



//등록하기
export default {
  components:{
    AppBoardVue,
    TheHeaderVue,
  }
};


</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

a {
  text-decoration: none;
}
</style>
