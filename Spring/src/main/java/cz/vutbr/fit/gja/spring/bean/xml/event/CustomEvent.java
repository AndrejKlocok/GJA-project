package cz.vutbr.fit.gja.spring.bean.xml.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author Martin Kocour
 * created on 28/12/2018
 *
 * @see CustomEventPublisher
 * @see CustomEventSubscriber
 */
public class CustomEvent extends ApplicationEvent {

    private String message;

    /**
     * Creates new {@link CustomEvent}
     *
     * @param source The object on which the event initially occurred (never {@code null}).
     * @param msg Custom message.
     */
    public CustomEvent(Object source, String msg) {
        super(source);
        this.message = msg;
    }

    /**
     * Returns the message.
     *
     * @return Custom message.
     */
    public String getMessage() {
        return message;
    }
}
