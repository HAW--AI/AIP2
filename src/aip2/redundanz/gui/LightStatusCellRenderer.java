package aip2.redundanz.gui;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class LightStatusCellRenderer extends DefaultTableCellRenderer {
	private static final long serialVersionUID = 1L;

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
    		boolean hasFocus, int row, int column) {		
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        LightStatus status = (LightStatus) value;
        setText(status.getDescription());
        setIcon(status.getImage());        
        return this;
    }
}
