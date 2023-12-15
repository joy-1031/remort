package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* 中略 */

public class DBManager {
	
	private static final String CN_STRING = "jdbc:oracle:thin:@//10.40.112.11:1521/dbsys";
	private static final String USER = "jz220109";
	private static final String PASS = "pass0109";
	private static DBManager self; // 自分を管理する変数
	/**
	 * コンストラクタ
	 */
	private DBManager() {
		/* 中略。ODBCドライバのロード */
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(ClassNotFoundException e) {
			System.out.println("JDBCドライバのロードに失敗しました");
			e.printStackTrace();
			return;
		}
	}
	/**
	 * インスタンスを取得するメソッド
	 */
	public static DBManager getInstance() {
		if (self == null) {					// まだ一度もインスタンス化してなければ
			self = new DBManager();
		}
		return self;
	}

	/**
	 * コネクションを取得
	 */
	protected Connection getConnection() throws SQLException {
		return DriverManager.getConnection(CN_STRING, USER, PASS);
	}
}

















