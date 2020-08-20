package com.rkeeves.pat4.route.data;

public class Good {


	public Good(byte id, String name, int base_price) {
		super();
		this.id = id;
		this.name = name;
		this.base_price = base_price;
	}

	public final byte id;
	
	public final String name;
	
	public final int base_price;
}
