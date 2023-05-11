import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

//this.$store.state

//step01
// export default new Vuex.Store({
//   state: {
//     count:0,
//   },
// })

// //step02
// export default new Vuex.Store({
//   state: {
//     count:0,
//   },
//   getters:{
//     countMsg(state){
//       let msg = "10번 보다 "
//       if(state.count > 10 ) msg += "크다"
//       else msg += "작다"
//       return msg+"ㅇㅋ? (" + state.count + ")";
//     }
//   }
// })

// //step03
// export default new Vuex.Store({
//   state: {
//     count:0,
//   },
//   getters:{
//     countMsg(state){
//       let msg = "10번 보다 "
//       if(state.count > 10 ) msg += "크다"
//       else msg += "작다"
//       return msg+"ㅇㅋ? (" + state.count + ")";
//     },
//     msg1(state){return 'msg1(getters) : '+state.count},
//     msg2(state){return 'msg2(getters) : '+state.count},
//     msg3(state){return 'msg3(getters) : '+state.count},
//   }
// })

// //step04 , step05
// export default new Vuex.Store({
//   state: {
//     count:0,
//   },
//   getters:{
//     countMsg(state){
//       let msg = "10번 보다 "
//       if(state.count > 10 ) msg += "크다"
//       else msg += "작다"
//       return msg+"ㅇㅋ? (" + state.count + ")";
//     },
//     msg1(state){return 'msg1(getters) : '+state.count},
//     msg2(state){return 'msg2(getters) : '+state.count},
//     msg3(state){return 'msg3(getters) : '+state.count},
//   },
//   mutations:{
//     ADD_ONE(state){
//       state.count +=1;
//     },

//     ADD_TEN_COUNT(state, payload){
//       state.count += payload;
//     },

//     ADD_OBJ_COUNT(state, payload){
//       state.count += payload.num;
//     }
//   }
// })

//step06
export default new Vuex.Store({
  state: {
    count:0,
  },
  getters:{
    countMsg(state){
      let msg = "10번 보다 "
      if(state.count > 10 ) msg += "크다"
      else msg += "작다"
      return msg+"ㅇㅋ? (" + state.count + ")";
    },
    msg1(state){return 'msg1(getters) : '+state.count},
    msg2(state){return 'msg2(getters) : '+state.count},
    msg3(state){return 'msg3(getters) : '+state.count},
  },
  mutations:{
    ADD_ONE(state){
      state.count +=1;
    },

    ADD_TEN_COUNT(state, payload){
      state.count += payload;
    },

    ADD_OBJ_COUNT(state, payload){
      state.count += payload.num;
    }
  }
  ,
  actions:{
    asyncAddOne(context,payload){
      context.commit('ADD_TEN_COUNT',payload);
    },
  }
})