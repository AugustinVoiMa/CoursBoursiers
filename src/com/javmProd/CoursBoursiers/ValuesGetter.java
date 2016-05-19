package com.javmProd.CoursBoursiers;

import java.util.HashSet;

class ValuesGetter {
	private HashSet<String> namesToGet;
	
	public ValuesGetter(){
		this.namesToGet = new HashSet<String>();
		
	}
	public void addNameToGet(String name){
		this.namesToGet.add(name);
	}
	public void removeNameToGet(String name){
		this.namesToGet.remove(name);
	}
	public void clearNamesToGet(){
		this.namesToGet.clear();
	}
	public void setNamesToGet(HashSet<String> names){
		this.namesToGet = names;
	}
	public HashSet<String> getNamesToGet(){
		return this.namesToGet;
	}
	
	
}
