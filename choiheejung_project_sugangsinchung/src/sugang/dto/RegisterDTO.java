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
		return "수강신청 [학생학번=" + stid + ", 학수번호=" + corid + ", 점수=" + score + "]";
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
