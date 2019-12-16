package dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import config.DBconnection;
import main.TopPanel1;
import model.ListObjectdata;
import model.UserData;
import myGraph.GraphPanel;

public class GetWalletDao {
	
	public void getWalletData(DBconnection db, UserData userData, TopPanel1 tp, GraphPanel graphPanel, ListObjectdata listObjectData) {
		Statement statement;
		ResultSet resultSet;
		
		try {
			String queryString = "select user_total_money, user_income_total, user_outcome_total from mywallet.user  where user_idx=1;";
			
			// ② 연결 [Statement]
			statement = db.getConnection().createStatement();
			
			// ③ 실행 [CRUD]
			resultSet = statement.executeQuery(queryString);
			
			// 컬럼 정보 가져오기
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			
			while (resultSet.next())
			{
				userData.setUserData(resultSet.getInt("user_total_money"), resultSet.getInt("user_income_total"), resultSet.getInt("user_outcome_total"));
				System.out.println(resultSet.getInt("user_total_money") + "\t" + resultSet.getInt("user_income_total") + "\t" + resultSet.getInt("user_outcome_total"));
				tp.balance.setText("$"+Integer.toString(userData.getTotalMoney())+"남음");
				tp.onToday.setText("잔액 $"+userData.getTotalMoney());
				tp.yester.setText("지출 누적 금액 $"+userData.getOutcomeMoney());
				tp.currentMonth.setText("수입 누적 금액 $"+userData.getIncomeMoney());
				graphPanel.setTotalMoney(resultSet.getInt("user_outcome_total"),resultSet.getInt("user_income_total"), resultSet.getInt("user_total_money") );
			}
			
		}
		catch (SQLException e)
		{
			System.out.println("[쿼리 오류]\n" + e.getStackTrace());
		}
		finally
		{
			// ④ 닫기
			db.closeDatabase();
		}
		
	}
	
	public void getwalletListDao(DBconnection db, UserData userData, TopPanel1 tp, ListObjectdata listObjectData) {
		Statement statement;
		ResultSet resultSet;
		
		try {
			String queryString = "select list_detail_category, list_money, list_type, DAYNAME( mywallet.list.date ) as date FROM mywallet.list where user_idx=1 order by list_idx DESC;";
			
			// ② 연결 [Statement]
			statement = db.getConnection().createStatement();
			
			// ③ 실행 [CRUD]
			resultSet = statement.executeQuery(queryString);
			// 컬럼 정보 가져오기
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			
			while (resultSet.next()) {
				listObjectData.setListData( resultSet.getString("list_detail_category"), resultSet.getInt("list_money"), resultSet.getInt("list_type"), resultSet.getString("date"));
			}
			
			for(int i=0; i<listObjectData.listData.size(); i++) {
				Object[] newROw = {listObjectData.listData.get(i).date, listObjectData.listData.get(i).list_type, listObjectData.listData.get(i).list_detail_category, listObjectData.listData.get(i).list_money };
				tp.defaultTableModel.addRow(newROw);
			}	
			
		}
		catch (SQLException e)
		{
			System.out.println("[쿼리 오류]\n" + e.getStackTrace());
		}
		finally
		{

			// ④ 닫기
			db.closeDatabase();
		}
	}
	
	public void getDaysOutcomeMoneyDao(DBconnection db, ListObjectdata listObjectData) {
		
		Statement statement;
		ResultSet resultSet;
		
		try {
			String queryString = "select DAYNAME( mywallet.list.date ) as day, date, sum(list_money) as sum from mywallet.list where list_type = 1 group by day order by day DESC;";
			
			// ② 연결 [Statement]
			statement = db.getConnection().createStatement();
			
			// ③ 실행 [CRUD]
			resultSet = statement.executeQuery(queryString);
			// 컬럼 정보 가져오기
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int j =0;
			while (resultSet.next()) {
				listObjectData.setOutweek(Integer.parseInt(resultSet.getString("sum")), j);
				j++;
			}
			
		}
		catch (SQLException e)
		{
			System.out.println("[쿼리 오류]\n" + e.getStackTrace());
		}
		finally
		{
			// ④ 닫기
			db.closeDatabase();
		}
	}
	public void getDaysIncomeMoneyDao(DBconnection db, ListObjectdata listObjectData) {
		
		Statement statement;
		ResultSet resultSet;
		
		try {
			String queryString = "select DAYNAME( mywallet.list.date ) as day, date, sum(list_money) as sum from mywallet.list where list_type = 0 group by day order by day DESC;";
			
			// ② 연결 [Statement]
			statement = db.getConnection().createStatement();
			
			// ③ 실행 [CRUD]
			resultSet = statement.executeQuery(queryString);
			// 컬럼 정보 가져오기
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int j =0;
			while (resultSet.next()) {
				listObjectData.setInweek(Integer.parseInt(resultSet.getString("sum")), j);
				j++;
			}
			
		}
		catch (SQLException e)
		{
			System.out.println("[쿼리 오류]\n" + e.getStackTrace());
		}
		finally
		{
			// ④ 닫기
			db.closeDatabase();
		}
	}
}
