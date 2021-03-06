package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import config.DBconnection;


public class IdDataDao {

	public void idSelectAll(DBconnection db) {
		Statement statement;
		ResultSet resultSet;
		
		try {
			String queryString = "SELECT id FROM user";
			
			// ② 연결 [Connection]
//			connection = DriverManager.getConnection(url, user, password);
			
			// ② 연결 [Statement]
			statement = db.getConnection().createStatement();
			
			// ③ 실행 [CRUD]
			resultSet = statement.executeQuery(queryString);
			
			// 컬럼 정보 가져오기
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

			// 컬럼 출력
			System.out.println(resultSetMetaData.getColumnName(1));

			while (resultSet.next())
			{
				System.out.println(resultSet.getString("id"));
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
