package com.example.notificationservice.bean;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Notifications extends RepresentationModel<Notifications>{
	
	@Id
	@GeneratedValue
	private int notifid;
	private String notifname;
	
	public int getNotifid() {
		return notifid;
	}
	public void setNotifid(int notifid) {
		this.notifid = notifid;
	}
	public String getNotifname() {
		return notifname;
	}
	public void setNotifname(String notifname) {
		this.notifname = notifname;
	}
}
