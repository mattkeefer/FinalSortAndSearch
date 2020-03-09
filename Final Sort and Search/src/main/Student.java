package main;

public class Student implements Comparable {

	private String name;
	private double gpa;
	
	public Student(String str, double d) {
		setName(str);
		setGpa(d);
	}
	
	public Student() {
		name = "";
		gpa = 5;
	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double d) {
		gpa = d;
	}
	
	public int compareTo(Object obj) {
		return ((Student)(obj)).getName().compareTo(name);
	}
	
	public String[] getInfo() {
		String[] out = new String[2];
		out[0] = name;
		out[1] = String.format("%.3f", gpa);
		return out;
	}
}