package aip2.redundanz.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.WindowConstants;

import aip2.redundanz.IMonitor;
import aip2.redundanz.IMonitorGUI;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class Dashboard extends javax.swing.JFrame {
	{
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static final long serialVersionUID = 1L;
	private JTable jTable;
	private JPopupMenu jPopupMenu;
	private JScrollPane jScrollPane;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("Usage: Dashboard MonitorIP");
			System.exit(-1);
		}
		
		// trying to find monitor
		IMonitorGUI monitor = null;
		try {
			Registry rmiRegistry = LocateRegistry.getRegistry(args[0]);
			monitor = (IMonitorGUI) rmiRegistry.lookup(IMonitor.NAME);
		} catch (NotBoundException e) {
			System.err.println("Monitor not running at "+args[0]+"!");
			System.exit(-1);
		} catch (RemoteException e) {
			System.err.println("Monitor not running at "+args[0]+"!");
			System.exit(-1);
		}
		
		final IMonitorGUI m = monitor;
		final Dashboard inst = new Dashboard(m);
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
		
		while(true) {
			inst.repaint();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
	
	public Dashboard(IMonitorGUI monitor) {
		super("HES - Dashboard");
		initGUI(monitor);
	}
	
	private void initGUI(final IMonitorGUI monitor) {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			{
				jPopupMenu = new JPopupMenu();
				JMenuItem jMenuItem = new JMenuItem("De-/Aktivieren");
				jMenuItem.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int row = jTable.getSelectedRow();
						String name = (String) jTable.getValueAt(row, 0);
						
						try {
							monitor.toggleSystemAlive(name.trim());
						} catch (RemoteException e1) {
							System.err.println("Monitor is not answering! "+e1.getMessage());
						}
					}					
				});
				jPopupMenu.add(jMenuItem);
			}
			{
				jTable = new JTable();
				jTable.setModel(new TableModelSystems(monitor));
				jTable.setDefaultRenderer(LightStatus.class, new LightStatusCellRenderer());
				jTable.setAutoCreateRowSorter(true);
				jTable.addMouseListener(new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent e) {}
					@Override
					public void mouseEntered(MouseEvent e) {}
					@Override
					public void mouseExited(MouseEvent e) {}
					@Override
					public void mousePressed(MouseEvent e) { showPopup(e); }
					@Override
					public void mouseReleased(MouseEvent e) { showPopup(e); }
					
				    private void showPopup(MouseEvent e) {
				        if (e.isPopupTrigger()) {
				            int row = jTable.rowAtPoint(e.getPoint());
				            int column = jTable.columnAtPoint(e.getPoint());
				            if (!jTable.isRowSelected(row)) jTable.changeSelection(row, column, false, false);
				            
				            jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
				        }
				      }
				});
				
				jScrollPane = new JScrollPane(jTable);
			}
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(jScrollPane, 0, 240, Short.MAX_VALUE)
				.addContainerGap());
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(jScrollPane, 0, 1164, Short.MAX_VALUE)
				.addContainerGap());
			pack();
			setSize(1200, 300);
		} catch (Exception e) {
		}
	}

}
