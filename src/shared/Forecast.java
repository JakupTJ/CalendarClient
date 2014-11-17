package shared;

public class Forecast {

	private String date;
	private String celsius;
	private String desc;

	// Settere og gettere for Forecast klassen
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
}
