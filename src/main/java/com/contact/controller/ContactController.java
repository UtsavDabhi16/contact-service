package com.contact.controller;

import com.contact.entity.Contact;
import com.contact.service.contactService;
import com.contact.service.contactServiceImpl;
//import com.squareup.okhttp.*;
//import com.squareup.okhttp.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private com.contact.service.contactService contactService;

//    @GetMapping("/users/{userId}")
//    public List<Contact> getContacts(@PathVariable("userId") Long userId) throws IOException {


//        OkHttpClient client = new OkHttpClient();
//
//        MediaType mediaType = MediaType.parse("application/json");
//        RequestBody body = RequestBody.create(mediaType, "{\"customerId\":\"1001\",\"meterApiName\":\"student\",\"meterValue\":2,\"meterTimeInMillis\":1619445706909}");
//        Request request = new Request.Builder()
//                .url("https://app.amberflo.io/ingest")
//                .post(body)
//                .addHeader("Accept", "application/json")
//                .addHeader("Content-Type", "application/json")
//                .addHeader("x-api-key", "146712b0-ebb5-11ec-bf2a-450298d98c27")
//                .build();
//
//        Response response = client.newCall(request).execute();

//        OkHttpClient client = new OkHttpClient();
//
//        MediaType mediaType = MediaType.parse("application/json");
//        RequestBody body = RequestBody.create(mediaType, "{\"customerId\":\"1001\",\"meterApiName\":\"nurse\",\"meterValue\":2,\"meterTimeInMillis\":1619445706909,\"dimensions\":{\" botad\":\"abc\"}}");
//        Request request = new Request.Builder()
//                .url("https://app.amberflo.io/ingest")
//                .post(body)
//                .addHeader("Accept", "application/json")
//                .addHeader("Content-Type", "application/json")
//                .addHeader("x-api-key", "146712b0-ebb5-11ec-bf2a-450298d98c27")
//                .build();
//
//        Response response = client.newCall(request).execute();

//        OkHttpClient client = new OkHttpClient();
//        MediaType mediaType = MediaType.parse("application/json");
//        RequestBody body = RequestBody.create(mediaType, "{\"customerId\":\"1001\",\"meterApiName\":\"dureation_demo\",\"meterValue\":5,\"meterTimeInMillis\":1619445706909}");
//        Request request = new Request.Builder()
//                .url("https://app.amberflo.io/ingest")
//                .post(body)
//                .addHeader("Accept", "application/json")
//                .addHeader("Content-Type", "application/json")
//                .addHeader("x-api-key", "146712b0-ebb5-11ec-bf2a-450298d98c27")
//                .build();
//
//        Response response = client.newCall(request).execute();
//        return this.contactService.getContactOfUser(userId);
//    }


    private contactServiceImpl jsonKafkaProducer;

    public ContactController(contactServiceImpl jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

//    Contact contact=new Contact(1,"utsav@gmail.com","Utsav",1);

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody Contact contact){
        System.out.println("This is user : "+contact);
        jsonKafkaProducer.sendMessage(contact);
        return ResponseEntity.ok("JSON Message send to the kafka topic");
    }
}
