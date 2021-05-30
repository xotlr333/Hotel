package net.tis.hotel;

import java.util.Date;

public class HotelReservationDTO {
  int  bookingnum;
  int  adult;
  int  children;
  Date  checkin;
  Date  checkout;
  String  name;
  String  email;
  String tel;
 
  
  
  public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getBookingnum() {
	return bookingnum;
}
public void setBookingnum(int bookingnum) {
	this.bookingnum = bookingnum;
}
public int getAdult() {
	return adult;
}
public void setAdult(int adult) {
	this.adult = adult;
}
public int getChildren() {
	return children;
}
public void setChildren(int children) {
	this.children = children;
}
public Date getCheckin() {
	return checkin;
}
public void setCheckin(Date checkin) {
	this.checkin = checkin;
}
public Date getCheckout() {
	return checkout;
}
public void setCheckout(Date checkout) {
	this.checkout = checkout;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public Date getBookingdate() {
	return bookingdate;
}
public void setBookingdate(Date bookingdate) {
	this.bookingdate = bookingdate;
}
String  phone;
  Date  bookingdate;


}
	