package com.google.hibernate.hibernate_1.pojo;

import java.util.List;

public class QueryResult {
private int count;//总记录数
private List list;//一页的数据
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public List getList() {
	return list;
}
public void setList(List list) {
	this.list = list;
}
public QueryResult() {
	super();
	// TODO Auto-generated constructor stub
}
public QueryResult(int count, List list) {
	super();
	this.count = count;
	this.list = list;
}

}
