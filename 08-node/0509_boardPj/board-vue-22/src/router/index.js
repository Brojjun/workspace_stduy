import Vue from 'vue'
import VueRouter from 'vue-router'

import AppBoard from '../views/AppBoard.vue';
import AppMain from '../views/AppMain.vue';
import AppUser from '../views/AppUser.vue';

// import board children
import BoardList from '../components/board/BoardList.vue';
import BoardDelete from '../components/board/BoardDelete.vue';
import BoardModify from '../components/board/BoardModify.vue';
import BoardView from '../components/board/BoardView.vue';
import BoardWrite from '../components/board/BoardWrite.vue';

Vue.use(VueRouter)

const routes = [
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
          path:'view/:no',
          name:'boardView',
          component:BoardView,
        },
      ],
    },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
