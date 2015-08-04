package lab06.sender;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyMessageSenderTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        MyMessageSender jmsMessageSender = (MyMessageSender) ctx.getBean("myMessageSender");

        // send to default destination
        final String msg1 = "hello JMS";
        System.out.println("Sending a message: "+msg1);
        jmsMessageSender.send(msg1);

        // send to a code specified destination
        Queue queue = new ActiveMQQueue("default");
        final String msg2 = "hello Another Message";
        System.out.println("Sending another message: "+msg2);
        jmsMessageSender.send(queue, msg2);

        // close spring application context
        ((ClassPathXmlApplicationContext) ctx).close();
    }
}
