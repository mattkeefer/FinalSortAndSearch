package main;

public class Widget implements Comparable {

	private int prodNum;
	private int numSold;
	
	public Widget(int i, int j) {
		setProdNum(i);
		setNumSold(j);
	}
	
	public Widget() {
		prodNum = 999;
		numSold = 0;
	}

	public int getProdNum() {
		return prodNum;
	}

	public void setProdNum(int i) {
		prodNum = i;
	}

	public int getNumSold() {
		return numSold;
	}

	public void setNumSold(int i) {
		numSold = i;
	}
	
	public int compareTo(Object obj) {
		if(numSold>((Widget)(obj)).getNumSold()) {
			return 1;
		}
		if(numSold<((Widget)(obj)).getNumSold()) {
			return -1;
		}
		return 0;
	}
	
	public String[] getInfo() {
		String[] out = new String[2];
		out[0] = String.format("%d", prodNum);
		out[1] = String.format("%d", numSold);
		return out;
	}
}