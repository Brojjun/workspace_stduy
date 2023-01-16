// @@DELETE_FILE:
package com.ssafy.f_interface.inter;

public class IronMan implements Heroable {
    int weaponDamage = 100;

    @Override
    public int fire() {
        System.out.printf("빔 발사: %d만큼의 데미지를 가함%n");
        return this.weaponDamage;
    }

    @Override
    public void changeShape(boolean isHeroMode) {
        String status = isHeroMode ? "장착" : "제거";
        System.out.printf("장갑 %s%n", status);
    }

    @Override
    public void upgrade() {
        System.out.printf("무기 성능 개선");
    }
}
