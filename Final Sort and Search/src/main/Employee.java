package main;

public class Employee implements Comparable {

	private String name;
	private double salary;
	
	public Employee(String str, double d) {
		name = str;
		salary = d;
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
}