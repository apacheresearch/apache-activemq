/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.activemq.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/")
public class IndexController {

  @Autowired
  JmsTemplate template;

  @Autowired
  ActiveMQTopic topic;

  @GetMapping()
  public ResponseEntity<?> index() {
    Map<String, Object> map = new HashMap<>();
    map.put("name", "Wahab Taofeek");
    map.put("handle", "wahabtaofeeqo");

    template.convertAndSend("chatQueue", map);
    return ResponseEntity.ok().body("Welcome");
  }

  @GetMapping("topic")
  public ResponseEntity<?> topic() {

    Map<String, Object> map = new HashMap<>();
    map.put("name", "Wahab Taofeek");
    map.put("handle", "wahabtaofeeqo");

    topic.setPhysicalName("users");
    template.convertAndSend(topic, map);

    //
    return ResponseEntity.ok().body("Topic sent");
  }

}
