package lab06.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

@Component
public class MyMessageListener implements MessageListener {

    @Override
    public void onMessage(Message msg) {
        try {
            String msgText;
            if (msg instanceof TextMessage) {
                msgText = ((TextMessage) msg).getText();
            } else {
                msgText = msg.toString();
            }

            System.out.println("Message Received: " + msgText);

            if (msgText.equalsIgnoreCase("quit")) {
                synchronized (this) {
                    this.notifyAll(); // Notify main thread to quit
                }
            }
        } catch (JMSException jmse) {
            jmse.printStackTrace();
        }
    }

}
