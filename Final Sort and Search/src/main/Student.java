package main;

public class Student implements Comparable {

	private String name;
	private double gpa;
	
	public Student(String str, double d) throws FormatException {
		if(str.trim().equals("")) {
			throw new FormatException("Please enter a name.");
		}
		else {
			name = str;
		}
		if(d<0 || d>5) {
			throw new FormatException("GPA must be between 0-5.");
		}
		else {
			gpa = d;
		}
	}
	
	public Student() {
		name = "";
		gpa = 0;
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
		return name.compareTo(((Student)(obj)).getName());
	}
	
	public String[] getInfo() {
		String[] out = new String[2];
		out[0] = name;
		out[1] = String.format("%.3f", gpa);
		return out;
	}
	
	public boolean equals(String s) {
		return s.toLowerCase().equals(name.toLowerCase());
	}
}