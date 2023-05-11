<template>
  <div id="app">
    <nav>
      <router-link to="/step00">000</router-link> |
      <router-link to="/step01">111</router-link> |
      <router-link to="/step02">222</router-link> |
      <router-link to="/step03">333</router-link> |
      <router-link to="/step04">444</router-link> |
      <router-link to="/step05">555</router-link> |
      <router-link to="/step06">666</router-link> |
      <router-link to="/step07">171</router-link> |

    </nav>
    <router-view/>
  </div>
</template>

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
