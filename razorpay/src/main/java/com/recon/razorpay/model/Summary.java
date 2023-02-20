package com.recon.razorpay.model;

public class Summary {

	int paymentCount=0;
	int refundCount=0;
	int totalDemandSettlementcount=0;
	float paymentAmount;
	float refundAmount;
float paymentCredit;
float totalsumonDemandSelttle;
float sumCreditDemandSelttle;
float sumFeeDemandSelttle;

float pgcharge;
String settlementDate;
String recondateandtime;


public int getTotalDemandSettlementcount() {
	return totalDemandSettlementcount;
}
public void setTotalDemandSettlementcount(int totalDemandSettlementcount) {
	this.totalDemandSettlementcount = totalDemandSettlementcount;
}
public float getTotalsumonDemandSelttle() {
	return totalsumonDemandSelttle;
}
public void setTotalsumonDemandSelttle(float totalsumonDemandSelttle) {
	this.totalsumonDemandSelttle = totalsumonDemandSelttle;
}
public float getSumCreditDemandSelttle() {
	return sumCreditDemandSelttle;
}
public void setSumCreditDemandSelttle(float sumCreditDemandSelttle) {
	this.sumCreditDemandSelttle = sumCreditDemandSelttle;
}
public float getSumFeeDemandSelttle() {
	return sumFeeDemandSelttle;
}
public void setSumFeeDemandSelttle(float sumFeeDemandSelttle) {
	this.sumFeeDemandSelttle = sumFeeDemandSelttle;
}
public int getRefundCount() {
	return refundCount;
}
public void setRefundCount(int refundCount) {
	this.refundCount = refundCount;
}
public float getRefundAmount() {
	return refundAmount;
}
public void setRefundAmount(float refundAmount) {
	this.refundAmount = refundAmount;
}
public String getRecondateandtime() {
	return recondateandtime;
}
public void setRecondateandtime(String recondateandtime) {
	this.recondateandtime = recondateandtime;
}
public int getPaymentCount() {
	return paymentCount;
}
public void setPaymentCount(int paymentCount) {
	this.paymentCount = paymentCount;
}
public float getPaymentAmount() {
	return paymentAmount;
}
public void setPaymentAmount(float paymentAmount) {
	this.paymentAmount = paymentAmount;
}
public float getPaymentCredit() {
	return paymentCredit;
}
public void setPaymentCredit(float paymentCredit) {
	this.paymentCredit = paymentCredit;
}
public float getPgcharge() {
	return pgcharge;
}
public void setPgcharge(float pgcharge) {
	this.pgcharge = pgcharge;
}
public String getSettlementDate() {
	return settlementDate;
}
public void setSettlementDate(String settlementDate) {
	this.settlementDate = settlementDate;
}
@Override
public String toString() {
	return "Summary [paymentCount=" + paymentCount + ", paymentAmount=" + paymentAmount + ", paymentCredit="
			+ paymentCredit + ", pgcharge=" + pgcharge + ", settlementDate=" + settlementDate + ", recondateandtime="
			+ recondateandtime + "]";
}




	
	
	
}
