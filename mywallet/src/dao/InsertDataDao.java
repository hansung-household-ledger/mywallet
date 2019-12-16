package dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import config.DBconnection;

public class InsertDataDao {

	public void insertIncomeData(DBconnection db, int money,int type, String category) {
		Statement statement;

		try {
			String queryString = "update mywallet.user set user.user_total_money = user_total_money + "+money+", user.user_income_total = user_income_total + "+money+" where user_idx=1;";
			
			// ② 연결 [Statement]
			statement = db.getConnection().createStatement();
			
			// ③ 실행 [CRUD]
			statement.executeUpdate(queryString);
		}
		catch (SQLException e) {
			System.out.println("[쿼리 오류]\n" + e.getStackTrace());
		}
		finally {
			// ④ 닫기
			db.closeDatabase();
		}
		
	}
	
	public void insertList(DBconnection db, int money,int type, String category) {
		Statement statement;

		try {
			String queryString = "insert into mywallet.list (list_detail_category, list_money, list_type, user_idx) values ('"+category+"',"+ money+","+type+",1);";
			
			// ② 연결 [Statement]
			statement = db.getConnection().createStatement();
			
			// ③ 실행 [CRUD]
			statement.executeUpdate(queryString);
		}
		catch (SQLException e) {
			System.out.println("[쿼리 오류]\n" + e.getStackTrace());
		}
		finally {
			// ④ 닫기
			db.closeDatabase();
		}
		
	}
	
	public void insertOutcomeData(DBconnection db, int money,int type, String category) {
		Statement statement;

		try {
			String queryString = "update mywallet.user set user.user_total_money = user_total_money - "+money+", user.user_outcome_total = user_outcome_total + "+money+" where user_idx=1;";
			
			// ② 연결 [Statement]
			statement = db.getConnection().createStatement();
			
			// ③ 실행 [CRUD]
			statement.executeUpdate(queryString);
		}
		catch (SQLException e) {
			System.out.println("[쿼리 오류]\n" + e.getStackTrace());
		}
		finally {
			// ④ 닫기
			db.closeDatabase();
		}
		
	}
		
}
