package model;

/**
 * ビデオテーブルのデータを表す
 * 
 * @author 22jz0109
 *
 */
public class Video {
	private int id;
	private String title;
	private String synopsisShort;
	private String synopsisLong;
	private boolean pcNg;
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getSynopsisShort() {
		return synopsisShort;
	}
	public String getSynopsisLong() {
		return synopsisLong;
	}
	public boolean isPcNg() {
		return pcNg;
	}
	//コンストラクタ
	public Video() {}	//引数なしコンストラクタ
	
	
	public Video(int id, String title, String synopsisShort, String synopsisLong, boolean pcNg) {
		this.id = id;
		this.title = title;
		this.synopsisShort = synopsisShort;
		this.synopsisLong = synopsisLong;
		this.pcNg = pcNg;
	}
}
