package cz.vutbr.fit.gja.spring.bean.xml.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

/**
 * @author Martin Kocour
 * created on 28/12/2018
 *
 * Subscriber for {@link CustomEvent}.
 * This example demonstrate how to subscribe custom event.
 */
public class CustomEventSubscriber implements ApplicationListener<CustomEvent> {


    /**
     * This method is called after CustomEvent is published.
     *
     * @see CustomEventPublisher
     * @param customEvent Published event.
     */
    @Override
    public void onApplicationEvent(CustomEvent customEvent) {
        System.out.print("Subscriber: received CustomEvent(");
        System.out.print(customEvent.getMessage());
        System.out.println(")");
    }
}
