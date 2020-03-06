package main;
import BreezySwing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SickNastyUI extends GBFrame {

	JMenuItem addEmp = addMenuItem("Add", "Employee");
	JMenuItem addStu = addMenuItem("Add", "Student");
	JMenuItem addWid = addMenuItem("Add", "Widget");
	JMenuItem viewEmp = addMenuItem("View", "Employee");
	JMenuItem viewStu = addMenuItem("View", "Student");
	JMenuItem viewWid = addMenuItem("View", "Widget");
	
	JPanel output = addPanel(1,1,4,1);
	JTable table = null;
	DefaultTableModel model = null;
	Object[][] data;
	
	ArrayList<Comparable> list;
	
	public SickNastyUI() {
		addEmp.setBackground(new Color(237, 221, 202));
		addStu.setBackground(new Color(237, 221, 202));
		addWid.setBackground(new Color(237, 221, 202));
		addEmp.setForeground(new Color(173, 42, 28));
		addStu.setForeground(new Color(173, 42, 28));
		addWid.setForeground(new Color(173, 42, 28));
		list = new ArrayList<>();
		
		String[] columnNames = {"", ""};
		data = new String[25][5];
		output.setLayout(new BorderLayout());
		table = new JTable(data, columnNames);
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
		JScrollPane scrollpane = new JScrollPane(table);
		output.add(scrollpane);
		table.disable();
	}
	
	public static void main(String[] args) {
		JFrame frm = new SickNastyUI();
		frm.getContentPane().setBackground(new Color(237, 221, 202));
		frm.setTitle("Very Cool Program");
		frm.setSize(600, 350);
		frm.setVisible(true);
	}
	
	public void menuItemSelected(JMenuItem item ) {
		if(item == addEmp) {
			AddDlg ad = new AddDlg(this, 0, list);
		}
		if(item == addStu) {
			AddDlg ad = new AddDlg(this, 1, list);
		}
		if(item == addWid) {
			AddDlg ad = new AddDlg(this, 2, list);
		}
		if(item == viewEmp) {
			String[] columnNames = {"Name", "Salary"};
			model.setColumnCount(0);
			for(String s : columnNames) {
				model.addColumn(s);
			}
		}
		if(item == viewStu) {
			String[] columnNames = {"Name", "GPA"};
			model.setColumnCount(0);
			for(String s : columnNames) {
				model.addColumn(s);
			}
		}
		if(item == viewWid) {
			String[] columnNames = {"Product Number", "Units Sold"};
			model.setColumnCount(0);
			for(String s : columnNames) {
				model.addColumn(s);
			}
		}
	}
	
	public ArrayList<Comparable> getEmployees() {
		
	}
	public ArrayList<Comparable> getStudents() {
		
	}
	public ArrayList<Comparable> getWidgets() {
	
	}
}