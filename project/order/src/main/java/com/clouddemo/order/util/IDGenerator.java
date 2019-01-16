package com.clouddemo.order.util;

import java.util.Random;

public class IDGenerator {

	public static synchronized String nextId() {
		Random rand = new Random(System.currentTimeMillis());
	    return String.valueOf(rand.nextInt(10000))+900000;
    }

}
