package shared;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable{

	private final long String = 2L;
	private int userid;
	private String email;
	private Timestamp created;
	private boolean active;
	private String password;
	private String overallID;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String userName) {
		this.email = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
}
