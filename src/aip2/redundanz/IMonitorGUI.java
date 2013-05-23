package aip2.redundanz;

import java.util.List;

public interface IMonitorGUI {
	
	public List<SystemData> getAllSystems();
	
	public void setSystemAlive(String name, boolean value);
}
