package com.ssafy.c_inheritance.person;

// is - a관계 ( 상속 )
public class SpiderMan extends Person {
	boolean isSpider;
	Spider spider; // has - a ( 포함 )
	
	public SpiderMan(String name) {
		super(name);
		this.spider = new Spider();
		this.isSpider = true;
	}
	
	@Override
	void jump() {
		if(this.isSpider) {
			this.spider.jump();
		}
		else {
			super.jump();
		}
	}
	
	void fireWeb() {
		if(isSpider) 
			this.spider.fireWeb();
		else
			System.out.println("사람일 때는 못쏴요~");
		//System.out.println(어떻게 쏘지 ? ㅠㅠ);
	}

	@Override
	public String toString() {
		return "SpiderMan [isSpider=" + isSpider + ", spider=" + spider + ", toString()=" + super.toString() + "]";
	}
	
	
}
