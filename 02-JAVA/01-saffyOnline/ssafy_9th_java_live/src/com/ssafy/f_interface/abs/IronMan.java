package com.ssafy.f_interface.abs;

public class IronMan implements Heroable{
	int weaponDamge = 100;
	@Override
	public void changeChape(boolean isHeroMode) {
		// TODO Auto-generated method stub
		String status = isHeroMode? "장착":"제거";
	}

	@Override
	public int fire() {
		// TODO Auto-generated method stub
		System.out.println("=====================>");
		return this.weaponDamge;
	}

	@Override
	public void upgrade() {
		// TODO Auto-generated method stub
		System.out.println("업그레이드 컨플리트");
	}
	
}
