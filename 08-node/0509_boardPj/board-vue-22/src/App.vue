<template>
  <div id="app">
    <TheHeaderVue></TheHeaderVue>   
  </div>
</template>

<script>
//불러오기
import TheHeaderVue from './components/TheHeader.vue';



//등록하기
export default {
  components:{
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
