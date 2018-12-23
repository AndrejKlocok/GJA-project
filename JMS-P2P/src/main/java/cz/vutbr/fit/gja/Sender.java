/*
 * ----------------------------------------------------------------------------
 * JMS Point to Point
 *
 * Author:       Tomáš Vlk
 * Date:         2018-12-02
 * File:         Sender.java
 * Description:  Implementation JMS Sender
 * ----------------------------------------------------------------------------
 */

package cz.vutbr.fit.gja;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


/**
 * JMS ActiveMQ Sender
 * @see http://activemq.apache.org/hello-world.html
 */
public class Sender {

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

            // Create a MessageProducer from the Session and destination (Queue)
            MessageProducer producer = session.createProducer(queue);

            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            // Pass first argument as message or send default message
            String message;
            if (args.length > 0) {
                message = args[0];
            } else {
                message = "Hello world!";
            }

            // Create a message
            TextMessage textMessage = session.createTextMessage(message);

            // Tell the producer to send the message
            System.out.println("Sent message: " + textMessage.hashCode());
            producer.send(textMessage);

            // Clean up
            producer.close();
            session.close();
            connection.close();

        } catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
    }
}
