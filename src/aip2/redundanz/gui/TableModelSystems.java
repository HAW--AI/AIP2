package aip2.redundanz.gui;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.AbstractTableModel;

import aip2.redundanz.IMonitorGUI;
import aip2.redundanz.SystemData;

public class TableModelSystems extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss"); 
	
	private IMonitorGUI monitor = null;
	private String[] columnNames = { "Name", "Hostname", "Requests", "Last Requesttime", "Last Starttime", "Uptime (h:m:s)", "Downtime (h:m:s)", "Status"};
	
    public TableModelSystems(IMonitorGUI monitor) {
    	super();
    	this.monitor = monitor;
    }

	public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {    	
        try {
			return monitor.getAllSystems().size();
		} catch (RemoteException e) {
			return 0;
		}
    }

	public Class<?> getColumnClass(int col) {
		switch (col) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
				return String.class;
			case 7:
				return LightStatus.class;
		}
		return String.class;
	}
    
    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
    	SystemData r = null;
		try {
			r = monitor.getAllSystems().get(row);
		} catch (RemoteException e) {
		}
    	if (r == null) return "";
    	
    	switch(col) {
    		case 0: return r.getName();
    		case 1: return r.getHostname();
    		case 2: return r.getRequestCounter();
    		case 3: return TIME_FORMAT.format(new Date(r.getLastRequest()));
    		case 4: return TIME_FORMAT.format(new Date(r.getStartTime()));
    		case 5: return formatDuration(r.getUpTime(), r.getDownTime());
    		case 6: return formatDuration(r.getDownTime(), r.getUpTime());
    		case 7: return (r.isAlive() ? (r.isEnabled() ? LightStatus.GREEN : LightStatus.YELLOW) : LightStatus.RED);
    		default: return "";
    	}
    }

	public boolean isCellEditable(int row, int col) {
        return false;
    }
    
    public void setValueAt(Object value, int row, int col) {
        // nope
    }
    
    private String formatDuration(long duration, long duration2) {
    	long timeSeconds = (duration + duration2) / 1000;
    	long durSeconds = duration / 1000;    	
    	long hours = durSeconds / 3600;
    	long minutes = (durSeconds % 3600) / 60;
    	long seconds = (durSeconds % 3600) % 60;
    	
    	return (hours < 10 ? "0" : "")+hours+":"+
    			(minutes < 10 ? "0" : "")+minutes+":"+ 
    			(seconds < 10 ? "0" : "")+seconds+" ("+(int)Math.round(1.0 * durSeconds / timeSeconds * 100.0)+"%)";
    }
}
