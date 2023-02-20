package com.recon.razorpay.model;


public class Item {

	private String entity_id="";
	private Integer debit;
	private Integer credit;
	private Integer amount;
	private String currency="";
	private Integer fee;
	private Integer tax;

	private String type="";
	
	private Boolean on_hold;
	private Boolean settled;
	private Integer created_at;
	private Integer settled_at;
	private String settlement_id="";
	private Object postedAt;
	private String credit_type;
	private Object description;
	private String notes;
	private Object payment_id;
	private String settlement_utr;
	private String order_id;
	private String order_receipt;
	private String method;
	private String card_network;
	private String card_issuer;
	private String card_type;
	private Object dispute_id;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEntity_id() {
		return entity_id;
	}
	public void setEntity_id(String entity_id) {
		this.entity_id = entity_id;
	}
	public Integer getDebit() {
		return debit;
	}
	public void setDebit(Integer debit) {
		this.debit = debit;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Integer getFee() {
		return fee;
	}
	public void setFee(Integer fee) {
		this.fee = fee;
	}
	public Integer getTax() {
		return tax;
	}
	public void setTax(Integer tax) {
		this.tax = tax;
	}
	public Boolean getOn_hold() {
		return on_hold;
	}
	public void setOn_hold(Boolean on_hold) {
		this.on_hold = on_hold;
	}
	public Boolean getSettled() {
		return settled;
	}
	public void setSettled(Boolean settled) {
		this.settled = settled;
	}
	public Integer getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Integer created_at) {
		this.created_at = created_at;
	}
	public Integer getSettled_at() {
		return settled_at;
	}
	public void setSettled_at(Integer settled_at) {
		this.settled_at = settled_at;
	}
	public String getSettlement_id() {
		return settlement_id;
	}
	public void setSettlement_id(String settlement_id) {
		this.settlement_id = settlement_id;
	}
	public Object getPostedAt() {
		return postedAt;
	}
	public void setPostedAt(Object postedAt) {
		this.postedAt = postedAt;
	}
	public String getCredit_type() {
		return credit_type;
	}
	public void setCredit_type(String credit_type) {
		this.credit_type = credit_type;
	}
	public Object getDescription() {
		return description;
	}
	public void setDescription(Object description) {
		this.description = description;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Object getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(Object payment_id) {
		this.payment_id = payment_id;
	}
	public String getSettlement_utr() {
		return settlement_utr;
	}
	public void setSettlement_utr(String settlement_utr) {
		this.settlement_utr = settlement_utr;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getOrder_receipt() {
		return order_receipt;
	}
	public void setOrder_receipt(String order_receipt) {
		this.order_receipt = order_receipt;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getCard_network() {
		return card_network;
	}
	public void setCard_network(String card_network) {
		this.card_network = card_network;
	}
	public String getCard_issuer() {
		return card_issuer;
	}
	public void setCard_issuer(String card_issuer) {
		this.card_issuer = card_issuer;
	}
	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	public Object getDispute_id() {
		return dispute_id;
	}
	public void setDispute_id(Object dispute_id) {
		this.dispute_id = dispute_id;
	}
	@Override
	public String toString() {
		return "Item [entity_id=" + entity_id + ", debit=" + debit + ", credit=" + credit + ", amount=" + amount
				+ ", currency=" + currency + ", fee=" + fee + ", tax=" + tax + ", type=" + type + ", on_hold=" + on_hold
				+ ", settled=" + settled + ", created_at=" + created_at + ", settled_at=" + settled_at
				+ ", settlement_id=" + settlement_id + ", postedAt=" + postedAt + ", credit_type=" + credit_type
				+ ", description=" + description + ", notes=" + notes + ", payment_id=" + payment_id
				+ ", settlement_utr=" + settlement_utr + ", order_id=" + order_id + ", order_receipt=" + order_receipt
				+ ", method=" + method + ", card_network=" + card_network + ", card_issuer=" + card_issuer
				+ ", card_type=" + card_type + ", dispute_id=" + dispute_id + "]";
	}

	

}