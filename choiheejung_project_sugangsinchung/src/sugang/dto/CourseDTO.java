package sugang.dto;

public class CourseDTO {
	private String corid;
	private String corname;
	private String cordetail;
	public CourseDTO() {}
	public CourseDTO(String corid, String corname, String cordetail) {
		this.corid = corid;
		this.corname = corname;
		this.cordetail = cordetail;
	}
	@Override
	public String toString() {
		return "Course [학수번호="+corid+", 강의명="+corname+", 강의내용="+cordetail+"]";
	}
	public String getCorid() {
		return corid;
	}
	public void setCorid(String corid) {
		this.corid = corid;
	}
	public String getCorname() {
		return corname;
	}
	public void setCorname(String corname) {
		this.corname = corname;
	}
	public String getCordetail() {
		return cordetail;
	}
	public void setCordetail(String cordetail) {
		this.cordetail = cordetail;
	}
}
