package com.contact.service;

import com.contact.entity.Contact;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class contactServiceImpl implements contactService{

//    List<Contact> list=List.of(new Contact(1,"utsav@gmail.com","utsav", 1),new Contact(2,"jay@gmail.com","jay",2));
//
//    @Override
//    public List<Contact> getContactOfUser(long userId) {
//        return list.stream().filter(contact-> contact.getUserId()==(userId)).collect(Collectors.toList());
//    }

    KafkaTemplate<String, Contact> kafkaTemplate;

    @Autowired
    public contactServiceImpl(KafkaTemplate<String, Contact> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Contact data){
        Message<Contact> message= MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC,"utsav").build();
        kafkaTemplate.send(message);
    }
}
