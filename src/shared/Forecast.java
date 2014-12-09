package shared;

import java.io.Serializable;

public class Forecast implements Serializable{

	private final long serialversionUID = 5L; 
	private String date;
	private String celsius;
	private String desc;
	private String overallID = "getForecast";
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCelsius() {
		return celsius;
	}
	public void setCelsius(String celsius) {
		this.celsius = celsius;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	public String toString() {
		return "Today's forecast" +  "degrees: " + celsius + desc;
	}
}

	