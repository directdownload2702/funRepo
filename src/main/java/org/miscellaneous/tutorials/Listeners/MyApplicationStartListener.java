package org.miscellaneous.tutorials.Listeners;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class MyApplicationStartListener implements ApplicationListener<ContextStartedEvent>{
	
	@Override
	public void onApplicationEvent(ContextStartedEvent event) {
		System.out.println("Starting " + event);
	}
}
