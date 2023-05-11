import Vue from 'vue';
import VueRouter from 'vue-router';
import Step00View from '../views/Step00View.vue';
import Step01View from '../views/Step01View.vue';
import Step02View from '../views/Step02View.vue';
import Step03View from '../views/Step03View.vue';
import Step04View from '../views/Step04View.vue';
import Step05View from '../views/Step05View.vue';
import Step06View from '../views/Step06View.vue';
import Step07View from '../views/Step07View.vue';


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect:'/step00'
  },
  {
    path: '/step00',
    name: 'step00',
    component: Step00View,
    
  },
  {
    path: '/step01',
    name: 'step01',
    component: Step01View,
    
  },
  {
    path: '/step02',
    name: 'step02',
    component: Step02View,
    
  },
  {
    path: '/step03',
    name: 'step03',
    component: Step03View,
    
  },
  {
    path: '/step04',
    name: 'step04',
    component: Step04View,
    
  },
  {
    path: '/step05',
    name: 'step05',
    component: Step05View,
    
  },
  {
    path: '/step06',
    name: 'step06',
    component: Step06View,
    
  },
  {
    path: '/step07',
    name: 'step07',
    component: Step07View,
    
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
