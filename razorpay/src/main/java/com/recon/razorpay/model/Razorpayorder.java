package com.recon.razorpay.model;

import java.util.List;

public class Razorpayorder {
	//private Id id;
	private String orderId;
	private Integer totalAmount;
	private List<String> items = null;
	private List<Integer> itemsCost = null;
	private String notes;
	private String currency;
	private String status;
	private Long createdAt;
	private Long updatedAt;
	private String razorPayOrderId;
	private Success success;
	private Object error;
	private String reconstatus;
	
	
	
	public String getReconstatus() {
		return reconstatus;
	}
	public void setReconstatus(String reconstatus) {
		this.reconstatus = reconstatus;
	}
	//public Id getId() {
	//	return id;
	//}
	//public void setId(Id id) {
//		this.id = id;
//	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Integer getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}
	public List<String> getItems() {
		return items;
	}
	public void setItems(List<String> items) {
		this.items = items;
	}
	public List<Integer> getItemsCost() {
		return itemsCost;
	}
	public void setItemsCost(List<Integer> itemsCost) {
		this.itemsCost = itemsCost;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}
	public Long getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Long updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getRazorPayOrderId() {
		return razorPayOrderId;
	}
	public void setRazorPayOrderId(String razorPayOrderId) {
		this.razorPayOrderId = razorPayOrderId;
	}
	public Success getSuccess() {
		return success;
	}
	public void setSuccess(Success success) {
		this.success = success;
	}
	public Object getError() {
		return error;
	}
	public void setError(Object error) {
		this.error = error;
	}
	@Override
	public String toString() {
		return "Razorpayorder [orderId=" + orderId + ", totalAmount=" + totalAmount + ", items=" + items
				+ ", itemsCost=" + itemsCost + ", notes=" + notes + ", currency=" + currency + ", status=" + status
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", razorPayOrderId=" + razorPayOrderId
				+ ", success=" + success + ", error=" + error + ", reconstatus=" + reconstatus + "]";
	}


}
