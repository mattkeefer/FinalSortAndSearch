package main;
import BreezySwing.*;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.*;

public class AddDlg extends GBDialog {
	
	JButton exit = addButton("Cancel", 5,1,1,1);
	JButton add = addButton("Add", 5,2,1,1);
	
	JLabel nameLbl = addLabel("Name:", 1,1,1,1);
	JTextField name = addTextField("", 1,2,1,1);
	JLabel salaryLbl = addLabel("Salary:", 2,1,1,1);
	DoubleField salary = addDoubleField(0, 2,2,1,1);
	
	JLabel nameLbl1 = addLabel("Name:", 1,1,1,1);
	JTextField name1 = addTextField("", 1,2,1,1);
	JLabel gpaLbl = addLabel("GPA:", 2,1,1,1);
	DoubleField gpa = addDoubleField(0, 2,2,1,1);
	
	JLabel prodLbl = addLabel("Product Number:", 1,1,1,1);
	JTextField prodNum = addTextField("", 1,2,1,1);
	JLabel soldLbl = addLabel("Number Sold:", 2,1,1,1);
	IntegerField soldNum = addIntegerField(0, 2,2,1,1);
	
	int id;
	ArrayList<Comparable> list;

	public AddDlg(JFrame frm, int i, ArrayList<Comparable> li) {
		super(frm);
		nameLbl.setVisible(false);
		name.setVisible(false);
		salaryLbl.setVisible(false);
		salary.setVisible(false);
		
		nameLbl1.setVisible(false);
		name1.setVisible(false);
		gpaLbl.setVisible(false);
		gpa.setVisible(false);
		
		prodLbl.setVisible(false);
		prodNum.setVisible(false);
		soldLbl.setVisible(false);
		soldNum.setVisible(false);
		
		getContentPane().setBackground(new Color(237, 221, 202));
		if(i==0) {
			setTitle("Add Employee");
			nameLbl.setVisible(true);
			name.setVisible(true);
			salaryLbl.setVisible(true);
			salary.setVisible(true);
			salary.setText("");
		}
		else if(i==1) {
			setTitle("Add Student");
			nameLbl1.setVisible(true);
			name1.setVisible(true);
			gpaLbl.setVisible(true);
			gpa.setVisible(true);
			gpa.setText("");
		}
		else {
			setTitle("Add Widget");
			prodLbl.setVisible(true);
			prodNum.setVisible(true);
			soldLbl.setVisible(true);
			soldNum.setVisible(true);
			soldNum.setText("");
		}
		id = i;
		list = li;
		setSize(400, 250);
		setVisible(true);
	}
	
	public void buttonClicked(JButton button) {
		if(button == add) {
			if(id==0) {
				Employee e = new Employee(name.getText(), salary.getNumber());
				list.add(e);
				dispose();
			}
			else if(id==1) {
				Student s = new Student(name1.getText(), gpa.getNumber());
				list.add(s);
				dispose();
			}
			else {
				try {
					Widget w = new Widget(prodNum.getText().trim(), soldNum.getNumber());
					list.add(w);
					dispose();
				}
				catch(FormatException e) {
					messageBox(e.getMessage());
				}
			}
		}
		if(button == exit) {
			dispose();
		}
	}
}