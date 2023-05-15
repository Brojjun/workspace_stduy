<template>
  <tr>
    <td>{{ article.articleno }}</td>
    <td>
      <router-link :to="{ name: 'boardview', params: { articleno: article.articleno } }">
        {{ article.subject }}
      </router-link>
    </td>
    <td>{{ article.userName }}</td>
    <td>{{ article.hit }}</td>
    <td>{{ article.registerTime }}</td>
  </tr>
</template>

<script>
export default {
  name: "BoardListItem",
  props: {
    article: Object,
  },
};
</script>

<style></style>
