package alert.utility;

public class UserBean {
String name="";
String mobile="";
String mailId="";
String evaluation="";
String role="";
String interest="";


public String getInterest() {
	return interest;
}
public void setInterest(String interest) {
	this.interest = interest;
}
public String getRole() {
	return role;
}
public  void setRole(String role) {
	this.role = role;
}
public String getEvaluation() {
	return evaluation;
}
public void setEvaluation(String evaluation) {
	this.evaluation = evaluation;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getMailId() {
	return mailId;
}
public void setMailId(String mailId) {
	this.mailId = mailId;
}
@Override
public String toString() {
	return "UserBean [name=" + name + ", mobile=" + mobile + ", mailId=" + mailId + ", evaluation=" + evaluation
			+ ", role=" + role + "]";
}


}
