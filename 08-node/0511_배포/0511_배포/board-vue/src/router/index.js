import Vue from "vue";
import VueRouter from "vue-router";
// views
import AppMain from "@/views/AppMain.vue";
import AppUser from "@/views/AppUser.vue";
// import AppBoard from "@/views/AppBoard.vue";

// components
// import BoardList from "@/components/board/BoardList";
// import BoardWrite from "@/components/board/BoardWrite";
// import BoardView from "@/components/board/BoardView";
// import BoardModify from "@/components/board/BoardModify";
// import BoardDelete from "@/components/board/BoardDelete";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "main",
    component: AppMain,
  },
  {
    path: "/user/login",
    name: "login",
    component: AppUser,
  },
  {
    path: "/board",
    name: "board",
    //component: AppBoard,
    component: () =>
      import(/* webpackChunkName: "board" */ "../views/AppBoard.vue"),
    redirect: "/board/list",
    children: [
      {
        path: "list",
        name: "boardlist",
        component: () =>
        import(/* webpackChunkName: "board" */ "../components/board/BoardList.vue"),
      },
      {
        path: "write",
        name: "boardwrite",
        component: () =>
        import(/* webpackChunkName: "board" */ "../components/board/BoardWrite.vue"),
      },
      {
        path: "view/:articleno",
        name: "boardview",
        component: () =>
        import(/* webpackChunkName: "board" */ "../components/board/BoardView.vue"),
      },
      {
        path: "modify",
        name: "boardmodify",
        component: () =>
        import(/* webpackChunkName: "board" */ "../components/board/BoardModify.vue"),
      },
      {
        path: "delete",
        name: "boarddelete",
        component: () =>
        import(/* webpackChunkName: "board" */ "../components/board/BoardDelete.vue"),
      },
    ],
  },
  // {
  //   path: "/about",
  //   name: "about",
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () =>
  //     import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  // },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
