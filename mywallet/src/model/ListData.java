package model;

public class ListData {
	public String list_detail_category; // 유형 
	public int list_money; // 사용 돈 
	public String list_type; // 지출,수입 
	public String date;

	
	public ListData(String list_detail_category, int list_money, String list_type, String date) {
		this.list_detail_category = list_detail_category;
		this.list_money=list_money;
		this.list_type=list_type;
		this.date = date;
	}
}
