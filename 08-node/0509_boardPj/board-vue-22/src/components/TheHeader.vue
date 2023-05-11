<template>
  <div class="header">
    <img src="@/assets/ssafy_logo.png" alt="" />
    <div>
      <router-link :to="{name: 'board'}">게시판</router-link>   |
      <router-link :to="{name: 'main'}">메인페이지</router-link>   |
      <router-link :to="{name: 'user'}">유저페이지</router-link>   

    </div>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "TheHeader",
};
</script>

<style scope>
img {
  width: 150px;
}

.header {
  padding: 30px;
  text-align: center;
  box-shadow: 0px 1px 10px rgba(159, 157, 157, 0.3);
}

a {
  font-weight: bold;
  color: #2c3e50;
}

a:hover {
  color: #42b983;
}
</style>
