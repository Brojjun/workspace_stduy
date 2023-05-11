<template>
  <tr>
    <router-link :to="'/board/view/' + article.no"><td>{{article.no}}</td></router-link>
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
  },
  methods:{
    findDetail(){

    },
  }
};
</script>

<style></style>
