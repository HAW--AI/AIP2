package aip2.redundanz;

class SystemData {
	private long startTime;
	private long lastAlive = 0;
	private boolean isDisabled = false;
	private long requestCounter = 0;
	private long millisecondsUp = 0;
	private String hostname = "Unknown";
	
	SystemData(String hostname) {
		startTime = System.currentTimeMillis();
		this.hostname = hostname;
	}

	long getLastAlive() {
		return lastAlive;
	}

	void setLastAlive(long lastAlive) {
		this.lastAlive = lastAlive;
	}

	boolean isDisabled() {
		return isDisabled;
	}

	void setDisabled(boolean isDisabled) {
		this.isDisabled = isDisabled;
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

	@Override
	public String toString() {
		return "SystemData [startTime=" + startTime + ", lastAlive="
				+ lastAlive + ", isDisabled=" + isDisabled
				+ ", requestCounter=" + requestCounter + ", millisecondsUp="
				+ millisecondsUp + ", hostname=" + hostname + "]";
	}
}
