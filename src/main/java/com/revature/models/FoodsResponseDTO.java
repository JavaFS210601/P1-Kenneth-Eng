/**
 * 
 */
package com.revature.models;

/**
 * @author Kenneth Eng
 *
 */
public class FoodsResponseDTO {
	
	int foodid;
	String foodname;
	String foodtype;
	String foodstatus;
	
	
	
	public FoodsResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public FoodsResponseDTO(int foodid,String foodname, String foodtype, String foodstatus) {
		super();
		this.foodid = foodid;
		this.foodname = foodname;
		this.foodtype = foodtype;
		this.foodstatus = foodstatus;
	}



	public int getFoodid() {
		return foodid;
	}



	public void setFoodid(int foodid) {
		this.foodid = foodid;
	}



	public String getFoodname() {
		return foodname;
	}



	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}



	public String getFoodtype() {
		return foodtype;
	}



	public void setFoodtype(String foodtype) {
		this.foodtype = foodtype;
	}



	public String getFoodstatus() {
		return foodstatus;
	}



	public void setFoodstatus(String foodstatus) {
		this.foodstatus = foodstatus;
	}
	
	
	
	
}
