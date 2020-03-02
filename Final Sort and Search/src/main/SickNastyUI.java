package main;
import BreezySwing.*;
import java.awt.Color;
import javax.swing.*;

public class SickNastyUI extends GBFrame {

	JMenuItem addEmp = addMenuItem("Add", "Employee");
	JMenuItem addStu = addMenuItem("Add", "Student");
	JMenuItem addWid = addMenuItem("Add", "Widget");
	
	public SickNastyUI() {
		addEmp.setBackground(new Color(237, 221, 202));
		addStu.setBackground(new Color(237, 221, 202));
		addWid.setBackground(new Color(237, 221, 202));
		addEmp.setForeground(new Color(173, 42, 28));
		addStu.setForeground(new Color(173, 42, 28));
		addWid.setForeground(new Color(173, 42, 28));
	}
	
	public static void main(String[] args) {
		JFrame frm = new SickNastyUI();
		frm.getContentPane().setBackground(new Color(237, 221, 202));
		frm.setTitle("Very Cool Program");
		frm.setSize(600, 350);
		frm.setVisible(true);
	}
}