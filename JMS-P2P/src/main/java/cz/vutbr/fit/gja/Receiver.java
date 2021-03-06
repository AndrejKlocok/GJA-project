/*
 * ----------------------------------------------------------------------------
 * JMS Point to Point
 *
 * Author:       Tomáš Vlk
 * Date:         2018-12-02
 * File:         Receiver.java
 * Description:  Implementation JMS Receiver
 * ----------------------------------------------------------------------------
 */

package cz.vutbr.fit.gja;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


/**
 * JMS ActiveMQ receiver
 * @see http://activemq.apache.org/hello-world.html
 */
public class Receiver {

    /**
     * Main function
     *
     * @param args Command line arguments
     * @param args
     */
    // Warnings are suppressed because Sender and Receiver use the same init code
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {

        try {
            // Create a ConnectionFactory. Default broker URL is : tcp://localhost:61616".
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);

            // Create a Connection
            Connection connection = connectionFactory.createConnection();

            // Message delivery doesn't begin until you start the connection
            connection.start();

            // Create a Session. The first argument (false in this case) means that the session is not transacted.
            // The second argument means that the session will automatically acknowledge messages when they have
            // been received successfully
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination (Queue)
            Queue queue = session.createQueue("TEST.Queue");

            // Create a MessageConsumer from the Session and destination (Queue)
            MessageConsumer consumer = session.createConsumer(queue);

            // Wait for a message synchronous. You can specify timeout by passing number as argument.
            // If asynchronous communication is desired, instantiate a MessageListener object and register it with
            // a MessageConsumer object. In order to avoid missing messages, the start() method should be called on
            // the connection after the listener has been registered.
            Message message = consumer.receive();

            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                String text = textMessage.getText();
                System.out.println("Received: " + text);
            } else {
                System.out.println("Received: " + message);
            }

            consumer.close();
            session.close();
            connection.close();

        } catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
    }
}
