package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Video;

/**
 * ビデオDAO
 * @author joy.okuhara
 *
 */
public class VideoDAO {
	/**
	 * ビデオテーブルのデータをすべて取得するメソッド
	 * @return ビデオデータ
	 */
	
	public List<Video> get() {
	List<Video> list = new ArrayList<>();
	
	DBManager manager = DBManager.getInstance();
	try(Connection cn = manager.getConnection()) {
		//データを全部取得
		String sql = "SELECT * FROM videos";
		PreparedStatement stmt = cn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		//取得したデータをリストに格納
		while (rs.next()) {
			Video video = rs2model(rs);
			list.add(video);
		}
	} catch(SQLException e) {
		e.printStackTrace();
	}
	return list;
}
/**
 * ビデオテーブル内から、主キーがid のレコードを返すメソッド
 * @param id 主キーの値
 * @return 発見したビデオデータ。見つからなければ null
 */
	public Video find(int id) {
		Video video = null;
		DBManager manager = DBManager.getInstance();
		try (Connection cn = manager.getConnection()) {
			String sql = "SELECT * FROM video WHERE id = ?";
			PreparedStatement stmt = cn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				video = rs2model(rs);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return video;
	}


/**
 * ResultSetの行データをモデルの形に変換するメソッド
 * @param rs 変換前のデータ
 * @return 変換後のデータ
 */
private Video rs2model(ResultSet rs) throws SQLException {
	int id = rs.getInt("id");/* ⑨ */
	String title = rs.getString("title");
	String synopsisShort= rs.getString("synopsis_short");
	String synopsisLong = rs.getString("synopsis_long");
	boolean pcNg = rs.getBoolean("pc_ng");
	
	return new Video(id, title, synopsisShort, synopsisLong, pcNg);
}


}








