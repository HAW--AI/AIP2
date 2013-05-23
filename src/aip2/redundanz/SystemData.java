package aip2.redundanz;

class SystemData {
	private String hostname = "Unknown";
	private String name = "";	
	private boolean isAlive = true;
	private boolean isEnabled = true;
	private long startTime;
	private long lastAlive = 0;
	private long lastRequest = 0;
	private long requestCounter = 0;
	private long millisecondsUp = 0;
	
	SystemData(String name, String hostname) {
		this.startTime = System.currentTimeMillis();
		this.lastAlive = this.startTime;
		this.lastRequest = this.startTime;
		this.hostname = hostname;
		this.name = name;
	}

	long getLastAlive() {
		return lastAlive;
	}

	void setLastAlive(long lastAlive) {
		this.lastAlive = lastAlive;
	}

	boolean isEnabled() {
		return isEnabled;
	}

	void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	long getRequestCounter() {
		return requestCounter;
	}

	void setRequestCounter(long requestCounter) {
		this.requestCounter = requestCounter;
	}

	long getMillisecondsUp() {
		return millisecondsUp;
	}

	void setMillisecondsUp(long millisecondsUp) {
		this.millisecondsUp = millisecondsUp;
	}	
	
	long getStartTime() {
		return startTime;
	}

	long getDownTime() {
		return System.currentTimeMillis() - startTime - millisecondsUp;
	}
	
	String getHostname() {
		return hostname;
	}

	void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public String getName() {
		return name;
	}

	public long getLastRequest() {
		return lastRequest;
	}

	public void setLastRequest(long lastRequest) {
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
