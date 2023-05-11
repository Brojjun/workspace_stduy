<template>
  <tr>
    <td>{{article.no}}</td>
    <td>{{article.title}}</td>
    <td>{{article.userNo}}</td>
    <td>{{article.hits}}</td>
    <td>{{article.registDate}}</td>
  </tr>
</template>

<script>
export default {
  name: "BoardListItem",
  props:{
    article: Object
  }
};
</script>

<style></style>
