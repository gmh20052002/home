package com.gmh.wzz.api.entity;

import java.io.Serializable;

public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	private String orderBy = "";
	public Order(){
		
	}
			
	public Order(String field, Sort sort) {
		if (field != null) {
			orderBy += field;
			if (sort != null) {
				if (Sort.DESC.equals(sort)) {
					orderBy += " " + Sort.DESC;
				} else {
					orderBy += " " + Sort.ASC;
				}
			}
			orderBy += ",";
		}
	}

	public Order setOrderBy(String field, Sort sort) {
		if (field != null) {
			orderBy += field;
			if (sort != null) {
				if (Sort.DESC.equals(sort)) {
					orderBy += " " + Sort.DESC;
				} else {
					orderBy += " " + Sort.ASC;
				}
			}
			orderBy += ",";
		}
		return this;
	}

	public String getOrderBy() {
		if (orderBy != null && orderBy.endsWith(",")) {
			orderBy = orderBy.substring(0, orderBy.length() - 1);
		}
		return orderBy;
	}
}
