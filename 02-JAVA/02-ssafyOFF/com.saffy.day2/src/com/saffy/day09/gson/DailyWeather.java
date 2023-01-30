package com.saffy.day09.gson;

import java.text.SimpleDateFormat;

/**
 * @author SSAFY
 *
 */
public class DailyWeather {
	private int afterDay;
	private int afterhour;
	private String weather;
	private String dir;
	public int getAfterDay() {
		return afterDay;
	}
	public void setAfterDay(int afterDay) {
		this.afterDay = afterDay;
	}
	public int getAfterhour() {
		return afterhour;
	}
	public void setAfterhour(int afterhour) {
		this.afterhour = afterhour;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	@Override
	public String toString() {
		return "DailyWeather [afterDay=" + afterDay + ", afterhour=" + afterhour + ", weather=" + weather + ", dir="
				+ dir + "]";
	}
	
	
	
}
