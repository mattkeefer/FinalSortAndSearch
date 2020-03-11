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
	JMenuItem viewEmp = addMenuItem("View", "Employees");
	JMenuItem viewStu = addMenuItem("View", "Students");
	JMenuItem viewWid = addMenuItem("View", "Widgets");
	
	JMenuItem pop = addMenuItem("Add", "Populate"); //populate menu item
	
	JButton selSort = addButton("Selection Sort", 2,1,2,1);
	JButton insSort = addButton("Insertion Sort", 2,3,2,1);
	JLabel spacer = addLabel("reeee", 3,1,1,1);
	JLabel searchLbl = addLabel("Search:", 4,1,1,1);
	JTextField search = addTextField("", 4,2,3,1);
	JButton linSearch = addButton("Sequential Search", 5,1,2,1);
	JButton binSearch = addButton("Binary Search", 5,3,2,1);
	
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
		search.setEnabled(false);
		linSearch.setEnabled(false);
		binSearch.setEnabled(false);
		list = new ArrayList<>();
		spacer.setForeground(new Color(237, 221, 202));
		
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
		if(button == linSearch) {
			try {
				if(lastViewed == 'E') {
					updateTable(s.linearSearch(search.getText().trim(), getEmployees(), 'E'));
				}
				if(lastViewed == 'S') {
					updateTable(s.linearSearch(search.getText().trim(), getStudents(), 'S'));
				}
				if(lastViewed == 'W') {
					updateTable(s.linearSearch(search.getText().trim(), getWidgets(), 'W'));
				}
			}
			catch(FormatException e) {
				messageBox(e.getMessage());
			}
		}
		if(button == binSearch) {
			try {
				if(lastViewed == 'E') {
					updateTable(s.binarySearch(search.getText().trim(), getEmployees(), 'E', new Employee(search.getText(), 0)));
				}
				if(lastViewed == 'S') {
					updateTable(s.binarySearch(search.getText().trim(), getStudents(), 'S', new Student(search.getText(), 0)));
				}
				if(lastViewed == 'W') {
					updateTable(s.binarySearch(search.getText().trim(), getWidgets(), 'W', new Widget(search.getText(), 0)));
				}
			}
			catch(FormatException e) {
				messageBox(e.getMessage());
			}
		}
	}
	
	public void menuItemSelected(JMenuItem item ) {
		if(item == addEmp) {
			AddDlg ad = new AddDlg(this, 0, list);
			if(lastViewed == 'E') {
				updateTable(getEmployees());
			}
			selSort.setEnabled(true);
			insSort.setEnabled(true);
			search.setEnabled(true);
			linSearch.setEnabled(true);
			binSearch.setEnabled(true);
		}
		if(item == addStu) {
			AddDlg ad = new AddDlg(this, 1, list);
			if(lastViewed == 'S') {
				updateTable(getStudents());
			}
			selSort.setEnabled(true);
			insSort.setEnabled(true);
			search.setEnabled(true);
			linSearch.setEnabled(true);
			binSearch.setEnabled(true);
		}
		if(item == addWid) {
			AddDlg ad = new AddDlg(this, 2, list);
			if(lastViewed == 'W') {
				updateTable(getWidgets());
			}
			selSort.setEnabled(true);
			insSort.setEnabled(true);
			search.setEnabled(true);
			linSearch.setEnabled(true);
			binSearch.setEnabled(true);
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
				search.setEnabled(true);
				linSearch.setEnabled(true);
				binSearch.setEnabled(true);
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