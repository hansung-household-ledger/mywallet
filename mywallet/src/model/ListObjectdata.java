package model;

import java.util.ArrayList;

public class ListObjectdata {
	
	public ArrayList<ListData> listData = new ArrayList<ListData>();
	
	public ArrayList getListData () {
		return this.listData;
	}
	
	public void setListData( String list_detail_category, int list_money, int list_type) {
		String type;
		if(list_type == 0) {
			//수입 
			type = "수입";
		} else {
			type = "지출";
		}
		ListData data = new ListData(list_detail_category, list_money, type);
		this.listData.add(data); 
	}
	
	public ListData getListData(int i) {
		return listData.get(i);
	}
	
}
