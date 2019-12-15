package dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import config.DBconnection;
import main.TopPanel1;
import model.UserData;

public class GetWalletDao {
	
	public void getWalletData(DBconnection db, UserData userData, TopPanel1 tp) {
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
			
			System.out.println(resultSetMetaData.getColumnName(1) + "\t" + resultSetMetaData.getColumnName(2) + "\t" + resultSetMetaData.getColumnName(3) + "\t" );

			
			while (resultSet.next())
			{
				userData.setUserData(resultSet.getInt("user_total_money"), resultSet.getInt("user_income_total"), resultSet.getInt("user_outcome_total"));
				System.out.println(resultSet.getInt("user_total_money") + "\t" + resultSet.getInt("user_income_total") + "\t" + resultSet.getInt("user_outcome_total"));
				tp.balance.setText("$"+Integer.toString(userData.getTotalMoney())+"남음");
				tp.onToday.setText("잔액 $"+userData.getTotalMoney());
				tp.yester.setText("지출 누적 금액 $"+userData.getOutcomeMoney());
				tp.currentMonth.setText("수입 누적 금액 $"+userData.getIncomeMoney());
				
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
