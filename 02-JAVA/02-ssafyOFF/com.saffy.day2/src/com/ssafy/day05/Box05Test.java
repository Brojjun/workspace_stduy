package com.ssafy.day05;

interface Drink {}

class Sprite implements Drink {}

interface Burger {}

class Hamburger implements Burger {}

class BurgerSet<D, B> implements Drink, Burger {}

class MixBox<T extends Drink & Burger> // drink와 burger를 동시에 가지고 있는 타입만 T에 올 수 있다.

public class Box05Test {
	public static void main(String[] args) {
		//MixBox<Hamburger> box = new MixBox<>();
		//MixBox<Hamburger> box = new MixBox<>();
		//MixBox<Sprite> box = new MixBox<>();
		MixBox<BurgerSet<Sprite, Hamburger>> box = new MixBox<>();
	}
}
