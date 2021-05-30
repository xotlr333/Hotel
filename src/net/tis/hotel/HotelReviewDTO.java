package net.tis.hotel;

import java.util.Date;

public class HotelReviewDTO {
int code;
String title;
String name;
String pwd;
String content;
Date wdate;
String wimg;
int likes;
int hits;
int rating;
int rcnt;

public int getRcnt() {
	return rcnt;
}
public void setRcnt(int rcnt) {
	this.rcnt = rcnt;
}
public int getRating() {
	return rating;
}
public void setRating(int rating) {
	this.rating = rating;
}
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Date getWdate() {
	return wdate;
}
public void setWdate(Date wdate) {
	this.wdate = wdate;
}
public String getWimg() {
	return wimg;
}
public void setWimg(String wimg) {
	this.wimg = wimg;
}
public int getLikes() {
	return likes;
}
public void setLikes(int likes) {
	this.likes = likes;
}
public int getHits() {
	return hits;
}
public void setHits(int hits) {
	this.hits = hits;
}



}
	
	