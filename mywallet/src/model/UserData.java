package model;

import java.util.ArrayList;

public class UserData {

	private int totalMoney;
	private int incomeMoney;
	private int outcomeMoney;
	
	
	public int getTotalMoney () {
		return this.totalMoney;
	}
	
	public int getIncomeMoney () {
		return this.incomeMoney;
	}
	
	public int getOutcomeMoney () {
		return this.outcomeMoney;
	}


	public void setUserData(int totalMoney, int incomeMoney, int outcomeMoney) {
		this.totalMoney = totalMoney;
		this.incomeMoney = incomeMoney;
		this.outcomeMoney = outcomeMoney;
	}
	

}
