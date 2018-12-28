package cz.vutbr.fit.gja.spring.bean.xml.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.util.Date;

/**
 * @author Martin Kocour
 * created on 28/12/2018
 *
 * This examples demonstrate how to publish custom event.
 */
public class CustomEventPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;

    /**
     * This method is called after the bean is instantiated.
     * We should save the publisher and use it to publish custom event.
     *
     * @param applicationEventPublisher Event publisher.
     */
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    /**
     * Publish custom event.
     *
     * @see CustomEventSubscriber
     */
    public void publish() {
        publisher.publishEvent(new CustomEvent(this,"Time:  " + new Date().getTime()));
    }
}
