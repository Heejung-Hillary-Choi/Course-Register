package sugang.dto;

public class RegisterDTO {
	private String stid;
	private String corid;
	private int score;
	public RegisterDTO() {}
	public RegisterDTO(String stid, String corid) {
		this.stid = stid;
		this.corid = corid;
		this.score = 0;
	}
	@Override
	public String toString() {
		return "������û [�л��й�=" + stid + ", �м���ȣ=" + corid + ", ����=" + score + "]";
	}
	public String getStid() {
		return stid;
	}
	public void setStid(String stid) {
		this.stid = stid;
	}
	public String getCorid() {
		return corid;
	}
	public void setCorid(String corid) {
		this.corid = corid;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
