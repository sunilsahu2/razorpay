package com.recon.razorpay.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RazorBean {

private String entity;
private Integer count;
private Item items[];


public String getEntity() {
return entity;
}

public void setEntity(String entity) {
this.entity = entity;
}

public Integer getCount() {
return count;
}

public void setCount(Integer count) {
this.count = count;
}

public Item[] getItems() {
	return items;
}

public void setItems(Item[] items) {
	this.items = items;
}




}