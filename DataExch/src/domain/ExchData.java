package domain;

public class ExchData {
	private int year;//年份
	private int day;//日数
	private float rainfall;//降水
	private float flow;//流量
	private float voltage;//电压
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public float getRainfall() {
		return rainfall;
	}
	public void setRainfall(float rainfall) {
		this.rainfall = rainfall;
	}
	public float getFlow() {
		return flow;
	}
	public void setFlow(float flow) {
		this.flow = flow;
	}
	public float getVoltage() {
		return voltage;
	}
	public void setVoltage(float voltage) {
		this.voltage = voltage;
	}
	@Override
	public String toString() {
		return "ExchData [year=" + year + ", day=" + day + ", rainfall="
				+ rainfall + ", flow=" + flow + ", voltage=" + voltage + "]";
	}
	
}
