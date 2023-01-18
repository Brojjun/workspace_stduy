package com.ssafy.d_encapsulation.p1;

class SamePackageChildClass extends Parent{
	public void test() {
		super.defaultVar = 10;
		super.publicVar = 10;
		super.protectVar = 10;
		super.privitVar = 10;
		//상속과 상관없이 접근제한자의 영향으로 사용이 결정된다.
	}
// TODO: Parent를 상속받고 Parent의 member들에 접근해보세요.
    // END:
}
