package com.google.hibernate.hibernate_2.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class User {
private int id;
private String name;
private Set<String> addressSet=new HashSet();//初始化了Set，后面用到时候更方便；
private List<String> addressList=new ArrayList();
private Map<String,String> addressMap=new HashMap();
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Set<String> getAddressSet() {
	return addressSet;
}
public void setAddressSet(Set<String> addressSet) {
	this.addressSet = addressSet;
}
public List<String> getAddressList() {
	return addressList;
}
public void setAddressList(List<String> addressList) {
	this.addressList = addressList;
}
public Map<String, String> getAddressMap() {
	return addressMap;
}
public void setAddressMap(Map<String, String> addressMap) {
	this.addressMap = addressMap;
}
public static void main(String[] args) {
	Set<String> treeSet = new TreeSet<String>();
}
}
