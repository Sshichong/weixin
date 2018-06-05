package com.sc.db;

public class Kaoshi {

	private int id;
	private String campus;
	private String time;
	private String course;
	private String major;
	private String direction;
	private String place;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Kaoshi() {
		
		// TODO Auto-generated constructor stub
	}
	public Kaoshi(int id, String campus, String time, String course, String major, String direction, String place) {
		super();
		this.id = id;
		this.campus = campus;
		this.time = time;
		this.course = course;
		this.major = major;
		this.direction = direction;
		this.place = place;
	}
	@Override
	public String toString() {
		return "Kaoshi [id=" + id + ", campus=" + campus + ", time=" + time + ", course=" + course + ", major=" + major
				+ ", direction=" + direction + ", place=" + place + "]";
	}
	
	
	
}
