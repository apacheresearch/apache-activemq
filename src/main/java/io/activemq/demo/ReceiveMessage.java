package io.activemq.demo;

import java.util.Map;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ReceiveMessage {

  @JmsListener(destination = "chatQueue")
  public void onMessage(@Payload Map<String, Object> data) {
    System.out.println("Recieved: " + data.get("name"));
  }

  @JmsListener(destination = "chatQueue")
  public void onMessage2(@Payload Map<String, Object> data) {
    System.out.println("Recieved2: " + data.get("name"));
  }

  @JmsListener(destination = "users", containerFactory = "topicFactory")
  public void onTopic(@Payload Object data) {
    System.out.println("Recieved a topic");
  }

  @JmsListener(destination = "users", containerFactory = "topicFactory")
  public void onTopic2(@Payload Object data) {
    System.out.println("Recieved a topic2");
  }
}
