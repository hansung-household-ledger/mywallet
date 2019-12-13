package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnection {
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	
	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://database-1.ceor5h1wx6xh.ap-northeast-2.rds.amazonaws.com:3306/sopt?useSSL=false";
	String user = "root";
	String password = "data1234";
	
	public DBconnection() {
		try {
			// ① 로드
			Class.forName(driverName);
			
			// ② 연결
			connection = DriverManager.getConnection(url, user, password);
			
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("[로드 오류]\n" + e.getStackTrace());
		}
		catch (SQLException e)
		{
			System.out.println("[연결 오류]\n" +  e.getStackTrace());
		}
		
	}
	
	public Connection getConnection () {
		return this.connection;
	}
	
	public void closeDatabase()
	{
		try
		{
			if( connection != null )
			{
				connection.close();
			}
			
			if( statement != null )
			{
				statement.close();
			}
			
			if( resultSet != null )
			{
				resultSet.close();
			}
		}
		catch (SQLException e)
		{
			System.out.println("[닫기 오류]\n" +  e.getStackTrace());
		}
	}
	

	public void productSelectAll(Connection connection) {

		try
		{
			String queryString = "SELECT name FROM user";

			// ② 연결 [Connection]
//			connection = DriverManager.getConnection(url, user, password);

			// ② 연결 [Statement]
			statement = connection.createStatement();
			
			// ③ 실행 [CRUD]
			resultSet = statement.executeQuery(queryString);
			
			// 컬럼 정보 가져오기
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

			// 컬럼 출력
			System.out.println(resultSetMetaData.getColumnName(1));

			while (resultSet.next())
			{
				System.out.println(resultSet.getString("name"));
			}
		}
		catch (SQLException e)
		{
			System.out.println("[쿼리 오류]\n" + e.getStackTrace());
		}
		finally
		{
			// ④ 닫기
			closeDatabase();
		}
		
	}
}