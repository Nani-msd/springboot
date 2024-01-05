package com.example.notificationservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.example.notificationservice.bean.Notifications;
import com.example.notificationservice.exception.NotificationNotFoundException;
import com.example.notificationservice.serv.NotifServ;

@RestController
@RequestMapping("/notif")
@CrossOrigin
public class NotifController {

	@Autowired
	NotifServ notifserv;
	
	@GetMapping("/get")
	public String rand() {
		return "nani";
	}
	
	@PostMapping("/add")
	public Notifications putNotif(@RequestBody Notifications notif) {
		Notifications v=notifserv.putNotif(notif);
		v.add(linkTo(methodOn(NotifController.class).putNotif(notif)).withSelfRel());
		return v;
	}
	
	@GetMapping("/{notifid}")
	public Notifications getNotif(@PathVariable int notifid) throws NotificationNotFoundException{
		Notifications notif1=notifserv.getNotif(notifid);
		notif1.add(linkTo(methodOn(NotifController.class).getNotif(notif1.getNotifid())).withSelfRel());
		return notif1;
	}
	
	@GetMapping("/getall")
	public List<Notifications> getAllNotif()throws NotificationNotFoundException{
		List<Notifications> x=new ArrayList<>();
		x=notifserv.getAllNotif();
		for(Notifications p:x) {
			p.add(linkTo(methodOn(NotifController.class).getNotif(p.getNotifid())).withSelfRel());
		}
		
		return x;
	}
}