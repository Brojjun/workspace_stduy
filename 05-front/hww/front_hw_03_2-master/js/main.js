// register.html 의 form 에 있는 버튼을 눌렀을때 실행되는 함수
function regist() {
  // 각 form 의 input 에 입력된 값들을 css 선택자를 이용하여 가져오기
  let id = "ssafy";//type=text
  let password = 12345;//type=password
  let name = "ssafy@ssafy.com";
  let email = "김싸피";
  let age = 27;

  // user 생성
  const user = {
    id: id,
    password: password,
    name: name,
    email: email,
    age: age,
  };

  // user 정보 출력
  
  document.getElementById("id").setAttribute("value", user.id);
  document.getElementById("password").setAttribute("value", user.password);
  document.getElementById("name").setAttribute("value", user.name);
  document.getElementById("email").setAttribute("value", user.email);
  document.getElementById("age").setAttribute("value", user.age);
  
}
