// var a = 10;
// console.log(a);

// var a = 20;
// console.log(a);

// let b = 10;
// console.log(b);

// // let b = 20
// // console.log(b)

// const c = 20;
// // c = 20;
// console.log(c);

// //배열이 가지고있는 레퍼런스는 바꿀수 없으나
// const ssafy = {
//   area: "서울",
//   class: 10,
// };
// //레퍼런스의 프로퍼티는 변경이 가능하다
// console.log(ssafy);
// ssafy.area = "대전";
// console.log(ssafy.area);

// // ssafy = {
// //   area: "대전",
// //   class: 5,
// // };

// const num = [];
// console.log(num);
// num.push(10);
// console.log(num);

// var i = 10;
// for (var i = 0; i < 5; i++) {
//   console.log(i);
// }
// console.log(i);

// var VS let Scope Test
function scope1() {
  var x = 11;
  if (true) {
    var x = 99;
    console.log(x); //99
  }
  console.log(x); //99
}
//scope1();

function scope2() {
  let x = 11;
  if (true) {
    let x = 99;
    console.log(x); //99
  }
  console.log(x); //11
}
//scope2();

function scope3() {
  if (true) {
    var x = 99;
    console.log(x); //99
  }
  console.log(x); //99
}
//scope3();

function scope4() {
  let x = 99;
  if (true) {
    console.log(x); //99
  }
  console.log(x); //99
}
///scope4();

function scope5() {
  if (true) {
    let x = 99;
    console.log(x); //99
  }
  console.log(x); //에러 (생성 자체가 안되어있음)
}
//scope5();
