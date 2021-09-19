package sugang.dto;

public class StudentDTO {
	private String stid;
	private String stname;
	private String stphone;
	public StudentDTO() {}
	public StudentDTO(String stid, String stname, String stphone) {
		this.stid = stid;
		this.stname = stname;
		this.stphone = stphone;
	}
	@Override
	public String toString() {
		return "Student [학번=" + stid + ", 이름=" + stname + ", 연락처=" + stphone + "]";
	}
	public String getStid() {
		return stid;
	}
	public void setStid(String stid) {
		this.stid = stid;
	}
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public String getStphone() {
		return stphone;
	}
	public void setStphone(String stphone) {
		this.stphone = stphone;
	}
}
