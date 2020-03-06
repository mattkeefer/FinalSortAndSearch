package main;

public class Student implements Comparable {

	private String name;
	private double gpa;
	
	public Student(String str, double d) {
		setName(str);
		setGpa(d);
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
}