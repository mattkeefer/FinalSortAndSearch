package main;

public class Widget implements Comparable {

	private String prodNum;
	private int numSold;
	
	public Widget(String s, int j) throws FormatException {
		if(s.length()==3) {
			for(char c : s.toCharArray()) {
				if(!Character.isDigit(c)) {
					throw new FormatException("Product number must consist of integers.");
				}
			}
			prodNum = s;
		}
		else {
			throw new FormatException("Product number must be of length 3.");
		}
		if(numSold<0) {
			throw new FormatException("Units sold cannot be negative.");
		}
		else {
			numSold = j;
		}
	}
	
	public Widget() {
		prodNum = "000";
		numSold = 0;
	}

	public String getProdNum() {
		return prodNum;
	}

	public void setProdNum(String s) {
		prodNum = s;
	}

	public int getNumSold() {
		return numSold;
	}

	public void setNumSold(int i) {
		numSold = i;
	}
	
	public int compareTo(Object obj) {
		if(getNumSold()>((Widget)(obj)).getNumSold()) {
			return -1;
		}
		if(getNumSold()<((Widget)(obj)).getNumSold()) {
			return 1;
		}
		return 0;
	}
	
	public String[] getInfo() {
		String[] out = new String[2];
		out[0] = prodNum;
		out[1] = String.format("%d", numSold);
		return out;
	}
	
	public boolean equals(String s) throws FormatException {
		try {
			return Integer.parseInt(s) == getNumSold();
		}
		catch(NumberFormatException e) {
			throw new FormatException("Please enter a valid integer.");
		}
	}
}