package com.javacourse.stack.stack;

public class CustomItem implements Comparable<CustomItem> {

	private int val;

	public CustomItem(int a) {
		val = a;
	}

	public int getVal() {
		return val;
	}


	@Override
	public int compareTo(CustomItem o) {
		return Integer.compare(o.getVal(), val);
	}
}