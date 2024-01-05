package com.example.notificationservice.serv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notificationservice.Repository.NotifRepository;
import com.example.notificationservice.bean.Notifications;
import com.example.notificationservice.exception.NotificationNotFoundException;

@Service
public class NotifServ {
	
	@Autowired
	NotifRepository notifrepo;
	
	public Notifications putNotif(Notifications notif) {
		notifrepo.save(notif);
		return notifrepo.findByNotifid(notif.getNotifid());
	}
	
	public Notifications getNotif(int notifid) throws NotificationNotFoundException{
		Notifications not=notifrepo.findByNotifid(notifid);
		if(not!=null) {
			return not;
		}
		else {
			throw new NotificationNotFoundException("the notification not found");
		}
	}
	
	public List<Notifications> getAllNotif(){
		List<Notifications> x=notifrepo.findAll();
		return x;
	}
}
