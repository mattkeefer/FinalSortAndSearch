package main;

public class Employee implements Comparable {

	private String name;
	private double salary;
	
	public Employee(String str, double d) throws FormatException {
		if(str.trim().equals("")) {
			throw new FormatException("Please enter a name.");
		}
		else {
			name = str;
		}
		if(d<0) {
			throw new FormatException("Salary cannot be negative.");
		}
		else {
			salary = d;
		}
	}
	
	public Employee() {
		name = "";
		salary = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String s) {
		name = s;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double d) {
		salary = d;
	}
	
	public int compareTo(Object obj) {
		if(salary>((Employee)(obj)).getSalary()) {
			return -1;
		}
		if(salary<((Employee)(obj)).getSalary()) {
			return 1;
		}
		return 0;
	}
	
	public String[] getInfo() {
		String[] out = new String[2];
		out[0] = name;
		out[1] = String.format("$%.2f", salary);
		return out;
	}
	
	public boolean equals(String s) throws FormatException {
		try {
			double d = Double.parseDouble(s);
			return d == salary;
		}
		catch(NumberFormatException e) {
			throw new FormatException("Search unsuccessful.");
		}
	}
}