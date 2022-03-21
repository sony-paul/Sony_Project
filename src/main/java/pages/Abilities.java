package pages;

public class Abilities {
	
	private String name;
	private String url;
	private boolean is_hidden;
	private int slot;
	private String[] skills;
	
	public Abilities(String name, String url, boolean is_hidden, int slot, String[] skills,String companyname,String emailid) {
		super();
		this.name = name;
		this.url = url;
		this.is_hidden = is_hidden;
		this.slot = slot;
		this.skills = skills;
		this.details=new Details(companyname,emailid);
	}
	
		
	
	public String[] getSkills() {
		return skills;
	}
	public void setSkills(String[] skills) {
		this.skills = skills;
	}
	public Details getDetails() {
		return details;
	}
	public void setDetails(Details details) {
		this.details = details;
	}
	private Details details;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean getIs_hidden() {
		return is_hidden;
	}
	public void setIs_hidden(boolean is_hidden) {
		this.is_hidden = is_hidden;
	}
	public int getSlot() {
		return slot;
	}
	public void setSlot(int slot) {
		this.slot = slot;
	}
	
	
	
	

}
