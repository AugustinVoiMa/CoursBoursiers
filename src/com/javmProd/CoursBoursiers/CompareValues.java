package com.javmProd.CoursBoursiers;

import java.util.Comparator;

public class CompareValues implements Comparator<Value> {
	public static int MIN = 0;
	public static int MAX = 1;
	public static int ByX = 2;
	private int method;
	CompareValues(int method){
		this.method=method;
	}
	public int compare(Value v1, Value v2){
		if(this.method == CompareValues.MIN)
			return summInt(v2.getLow()-v1.getLow());
		
		else if(this.method == CompareValues.MAX)
			return summInt(v1.getHigh()-v2.getHigh());
		
		else if (this.method == CompareValues.ByX)
			return summInt(v1.getDate().getTime()-v2.getDate().getTime());
		
		try {
			throw new BadComparisonMethodException("Unknown method of comparison for : "+this.method);
		} catch (BadComparisonMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-1);
		}
		return (Integer) null;
	}
	
	private int summInt(Double n){
		if(n>0.)
			return 1;
		else if(n<0.)
			return -1;
		return 0;
	}
	private int summInt(Long n){
		if(n>0)
			return 1;
		else if(n<0)
			return -1;
		return 0;
	}
}
