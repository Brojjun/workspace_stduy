import Vue from 'vue'
import VueRouter from 'vue-router'

import AppBoard from '../views/AppBoard.vue';
import AppMain from '../views/AppMain.vue';
import AppUser from '../views/AppUser.vue';

// import board children
import BoardList from '../components/board/BoardList.vue';
import BoardDelete from '../components/board/BoardList.vue';
import BoardModify from '../components/board/BoardList.vue';
import BoardView from '../components/board/BoardList.vue';
import BoardWrite from '../components/board/BoardList.vue';

const router = new VueRouter({
    mode:'history',
    routes : [
      {
        path:'/',
        name:'main',
        component: AppMain,
      },
      {
        path:'/user',
        name:'user',
        component:AppUser,
      },
      {
        path:'/board',
        name:'board',
        component: AppBoard,
        redirect:'board/list',
        children:[
          {
            path:'list',
            name:'boardList',
            component:BoardList,
          },
          {
            path:'delete',
            name:'boardDelete',
            component:BoardDelete,
          },
          {
            path:'modify',
            name:'boardModify',
            component:BoardModify,
          },
          {
            path:'write',
            name:'boardWrite',
            component:BoardWrite,
          },{
            path:'view',
            name:'boardView',
            component:BoardView,
          },
        ],
      },
  ]
})

//vue 주입
const route = new Vue({
  el: '#ro',
  router,
})


export default router
