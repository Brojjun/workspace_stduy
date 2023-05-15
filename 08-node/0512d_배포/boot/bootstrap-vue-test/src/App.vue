<template>
  <div id="app">
    <nav>
      <the-header-nav-bar></the-header-nav-bar>
    </nav>
    <router-view/>
  </div>
</template>


<script>
import TheHeaderNavBar from './components/TheHeaderNavBar.vue';

export default {
    name: 'App',
    components:{
      TheHeaderNavBar,
    },
    data() {
        return {
            
        };
    },

    mounted() {
        
    },

    methods: {
        
    },
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

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
