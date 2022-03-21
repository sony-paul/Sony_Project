package pages;

public class Details {
	
	private String companyname;
	private String emailid;
	
	public Details(String companyname, String emailid) {
		super();
		this.companyname = companyname;
		this.emailid = emailid;
	}

	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	

}
