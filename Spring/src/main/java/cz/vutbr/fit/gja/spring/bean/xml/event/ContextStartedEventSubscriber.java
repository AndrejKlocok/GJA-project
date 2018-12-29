package cz.vutbr.fit.gja.spring.bean.xml.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author Martin Kocour
 * created on 28/12/2018
 *
 * Handler for {@link ContextStartedEvent}.
 *
 * {@link ContextStartedEvent} is published after {@link AbstractApplicationContext#start()} is called.
 */
public class ContextStartedEventSubscriber implements ApplicationListener<ContextStartedEvent> {

    @Override
    public void onApplicationEvent(ContextStartedEvent contextStartedEvent) {
        System.out.println("ContextStartedEventSubscriber: received ContextStartedEvent");
    }
}
