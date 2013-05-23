package aip2.redundanz;

import java.io.Serializable;

public class SystemData implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String hostname = "Unknown";
	private String name = "";	
	private boolean isAlive = true;
	private boolean isEnabled = true;
	private long startTime;
	private long lastAlive = 0;
	private long lastRequest = 0;
	private long requestCounter = 0;
	private long millisecondsUp = 0;
	private long millisecondsDown = 0;
	
	SystemData(String name, String hostname) {
		this.startTime = System.currentTimeMillis();
		this.lastAlive = this.startTime;
		this.lastRequest = this.startTime;
		this.hostname = hostname;
		this.name = name;
	}

	public long getLastAlive() {
		return lastAlive;
	}

	void setLastAlive(long lastAlive) {
		this.lastAlive = lastAlive;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public long getRequestCounter() {
		return requestCounter;
	}

	void incRequestCounter() {
		this.requestCounter++;
	}

	public long getUpTime() {
		return millisecondsUp;
	}

	void addUpTime(long millisecondsUp) {
		this.millisecondsUp += millisecondsUp;
	}	
	
	public long getStartTime() {
		return startTime;
	}

	void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	
	public long getDownTime() {
		return (isAlive ? millisecondsDown : System.currentTimeMillis() - lastAlive + millisecondsDown);
	}
	
	void addDownTime(long millisecondsDown) {
		this.millisecondsDown += millisecondsDown;
	}	
	
	public String getHostname() {
		return hostname;
	}

	void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public boolean isAlive() {
		return isAlive;
	}

	void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public String getName() {
		return name;
	}

	public long getLastRequest() {
		return lastRequest;
	}

	void setLastRequest(long lastRequest) {
		this.lastRequest = lastRequest;
	}
	

	@Override
	public String toString() {
		return "SystemData [hostname=" + hostname + ", name=" + name
				+ ", isEnabled=" + isEnabled + ", isAlive=" + isAlive
				+ ", startTime=" + startTime + ", lastAlive=" + lastAlive
				+ ", lastRequest=" + lastRequest + ", requestCounter="
				+ requestCounter + ", millisecondsUp=" + millisecondsUp + "]";
	}
}
