package com.fruitsalad.fmtle.database;

public class English {
	private String english = "";
	private String symbol = "";
	private String chinese = "";
	private int count = 0;

	public English() {
	}

	public English(String english, String symbol, String chinese, int count) {
		this.english = english;
		this.symbol = symbol;
		this.chinese = chinese;
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getChinese() {
		return chinese;
	}

	public void setChinese(String chinese) {
		this.chinese = chinese;
	}
}
