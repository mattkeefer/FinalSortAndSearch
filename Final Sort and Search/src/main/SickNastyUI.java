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
	
	JMenuItem pop = addMenuItem("Add", "Populate"); //populate menu item
	
	JButton selSort = addButton("Selection Sort", 2,1,2,1);
	JButton insSort = addButton("Insertion Sort", 2,3,2,1);
	
	JPanel output = addPanel(1,1,4,1);
	JTable table = null;
	DefaultTableModel model = null;
	Object[][] data;
	
	ArrayList<Comparable> list;
	SortSearch s = new SortSearch();
	private char lastViewed;
	
	public SickNastyUI() {
		selSort.setEnabled(false);
		insSort.setEnabled(false);
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
	
	public void buttonClicked(JButton button) {
		if(button == selSort) {
			if(lastViewed == 'E') {
				updateTable(s.selectionSort(getEmployees(), getEmployees().size()));
			}
			if(lastViewed == 'S') {
				updateTable(s.selectionSort(getStudents(), getStudents().size()));
			}
			if(lastViewed == 'W') {
				updateTable(s.selectionSort(getWidgets(), getWidgets().size()));
			}
		}
		if(button == insSort) {
			if(lastViewed == 'E') {
				updateTable(s.insertionSort(getEmployees(), getEmployees().size()));
			}
			if(lastViewed == 'S') {
				updateTable(s.insertionSort(getStudents(), getStudents().size()));
			}
			if(lastViewed == 'W') {
				updateTable(s.insertionSort(getWidgets(), getWidgets().size()));
			}
		}
	}
	
	public void menuItemSelected(JMenuItem item ) {
		if(item == addEmp) {
			AddDlg ad = new AddDlg(this, 0, list);
			updateTable(getEmployees());
			selSort.setEnabled(true);
			insSort.setEnabled(true);
		}
		if(item == addStu) {
			AddDlg ad = new AddDlg(this, 1, list);
			updateTable(getStudents());
			selSort.setEnabled(true);
			insSort.setEnabled(true);
		}
		if(item == addWid) {
			AddDlg ad = new AddDlg(this, 2, list);
			updateTable(getWidgets());
			selSort.setEnabled(true);
			insSort.setEnabled(true);
		}
		if(item == pop) {
			try {
				list.add(new Employee("Bob", 4500));
				list.add(new Employee("Alex", 9780));
				list.add(new Employee("John", 1200));
				list.add(new Student("Adam", 3.956));
				list.add(new Student("Zach", 4.144));
				list.add(new Student("Adam", 2.565));
				list.add(new Widget("235", 2784));
				list.add(new Widget("457", 6436));
				list.add(new Widget("935", 1767));
				selSort.setEnabled(true);
				insSort.setEnabled(true);
			}
			catch(FormatException e) {
				messageBox(e.getMessage());
			}
		}
		if(item == viewEmp) {
			String[] columnNames = {"Name", "Salary"};
			model.setColumnCount(0);
			for(String s : columnNames) {
				model.addColumn(s);
			}
			updateTable(getEmployees());
			lastViewed = 'E';
		}
		if(item == viewStu) {
			String[] columnNames = {"Name", "GPA"};
			model.setColumnCount(0);
			for(String s : columnNames) {
				model.addColumn(s);
			}
			updateTable(getStudents());
			lastViewed = 'S';
		}
		if(item == viewWid) {
			String[] columnNames = {"Product Number", "Units Sold"};
			model.setColumnCount(0);
			for(String s : columnNames) {
				model.addColumn(s);
			}
			updateTable(getWidgets());
			lastViewed = 'W';
		}
	}
	
	private void updateTable(ArrayList<Comparable> arr) {
		model.setRowCount(0);
		for(Comparable c : arr) {
			if(c.getClass().equals(new Employee().getClass())) {
				model.addRow(((Employee) c).getInfo());
			}
			if(c.getClass().equals(new Student().getClass())) {
				model.addRow(((Student) c).getInfo());
			}
			if(c.getClass().equals(new Widget().getClass())) {
				model.addRow(((Widget) c).getInfo());
			}
		}
	}
	
	public ArrayList<Comparable> getEmployees() {
		ArrayList<Comparable> arr = new ArrayList<>();
		for(Comparable c : list) {
			if(c.getClass().equals(new Employee().getClass())) {
				arr.add(c);
			}
		}
		return arr;
	}
	public ArrayList<Comparable> getStudents() {
		ArrayList<Comparable> arr = new ArrayList<>();
		for(Comparable c : list) {
			if(c.getClass().equals(new Student().getClass())) {
				arr.add(c);
			}
		}
		return arr;
	}
	public ArrayList<Comparable> getWidgets() {
		ArrayList<Comparable> arr = new ArrayList<>();
		for(Comparable c : list) {
			if(c.getClass().equals(new Widget().getClass())) {
				arr.add(c);
			}
		}
		return arr;
	}
}