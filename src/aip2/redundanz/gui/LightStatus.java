package aip2.redundanz.gui;

import javax.swing.ImageIcon;

public enum LightStatus {
	GREEN("Running", "ampel_gruen"),
	YELLOW("Deactivated", "ampel_gelb"),
	RED("Dead", "ampel_rot");
	
	private String description;
	private ImageIcon image;
	
	private LightStatus(String desc, String file) {
		this.description = desc;
		this.image = new ImageIcon(LightStatus.class.getResource("res/"+file+".png"));
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public ImageIcon getImage() {
		return this.image;
	}
}