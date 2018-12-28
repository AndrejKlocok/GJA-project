package cz.vutbr.fit.gja.spring.bean.xml.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

/**
 * @author Martin Kocour
 * created on 28/12/2018
 */
public class ContextStoppedEventSubscriber implements ApplicationListener<ContextStoppedEvent> {
    @Override
    public void onApplicationEvent(ContextStoppedEvent contextStoppedEvent) {
        System.out.println("ContextStoppedEventSubscriber: received ContextStoppedEvent");
    }
}
