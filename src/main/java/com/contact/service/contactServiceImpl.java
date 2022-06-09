package com.contact.service;

import com.contact.entity.Contact;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class contactServiceImpl implements contactService{

    List<Contact> list=List.of(new Contact(1,"utsav@gmail.com","utsav", 1),new Contact(2,"jay@gmail.com","jay",2));

    @Override
    public List<Contact> getContactOfUser(long userId) {
        return list.stream().filter(contact-> contact.getUserId()==(userId)).collect(Collectors.toList());
    }
}
