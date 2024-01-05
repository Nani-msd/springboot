package com.example.notificationservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.notificationservice.bean.Notifications;

public interface NotifRepository extends JpaRepository<Notifications,Integer>{
	Notifications findByNotifid(int notifid);
}
