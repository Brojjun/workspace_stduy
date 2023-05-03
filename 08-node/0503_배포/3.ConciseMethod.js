// ConciseMethod (간결한 메소드)

// 함수 선언 형식
// function a() { } // 명명(익명) 함수 선언
// const a = function () { } // 명명 함수 표현
// const a = new Function('x', 'y', 'return x + y') // 함수 생성자

// ES6 이전
// const id = "ssafy";
// const name = "정현모";
// const age = 26;
// const user = {
//   id: id,
//   name: name,
//   age: age,
//   info: function () {
//     //this는 이함수를 가지고있는 상위의 레벨 을 가르킨다 (즉 user를 가르킴)
//     console.log(this.name + "(" + this.id + ") 나이 : " + this.age);
//   },
// };
// console.log(user);
// user.info();

// ES6 이후
const id = "ssafy";
const name = "정현모";
const age = 26;
const user = {
  id,
  name,
  age,
  info() {
    //this는 이함수를 가지고있는 상위의 레벨 을 가르킨다 (즉 user를 가르킴)
    console.log(this.name + "(" + this.id + ") 나이 : " + this.age);
  },
};
console.log(user);
user.info();
