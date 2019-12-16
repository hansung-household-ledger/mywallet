package model;

import java.util.ArrayList;

public class ListObjectdata {
	
	public ArrayList<ListData> listData = new ArrayList<ListData>();
	public int food;
	public int culture;
	public int shopping;
	public int ect;
	public int outweek[] = new int[7];
	public int inweek[] = new int[7];
	
	public ArrayList getListData () {
		return this.listData;
	}
	
	public void setOutweek (int outcomeweek, int i) {
		this.outweek[i] = outcomeweek;
	}
	
	public void setInweek (int incomeweek, int i) {
		this.inweek[i] = incomeweek;
	}
	
	public void getCategoryTotal (String list_detail_category, int list_money) {
		if(list_detail_category.equals("식비")) {
			food += list_money;
		}else if(list_detail_category.equals("문화생활")) {
			culture += list_money;
		}else if (list_detail_category.equals("쇼핑")) {
			shopping += list_money;
		} else {
			ect += list_money;
		}
}	
	
	public void setListData( String list_detail_category, int list_money, int list_type, String date) {
		String type;
		if(list_type == 0) {
			//수입 
			type = "수입";
		} else {
			type = "지출";
		}
		ListData data = new ListData(list_detail_category, list_money, type, date);
		this.listData.add(data); 
		getCategoryTotal(list_detail_category, list_money);
	}
	
	public ListData getListData(int i) {
		return listData.get(i);
	}
	
}
