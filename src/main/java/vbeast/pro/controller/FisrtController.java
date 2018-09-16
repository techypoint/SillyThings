package vbeast.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import vbeast.pro.aysnc.Async;
import vbeast.pro.database.model.Topic;
import vbeast.pro.database.service.TopicService;

/**
 * Created by varun on 12/9/18.
 */

@RestController
public class FisrtController {

    @Autowired
    Async async;

    @Autowired
    TopicService topicService;


    @RequestMapping("/dbTest")
    public void dbTest(){
        System.out.println("DB TEST START"+Thread.currentThread().getName()+"--"+Thread.currentThread().getId());
        Topic topic=null;
        for(int i=0;i<10000;i++) {
            topic = new Topic("varun", Thread.currentThread().getName() + "--" + Thread.currentThread().getId());
            topicService.save(topic);
        }
        System.out.println("DB TEST END"+Thread.currentThread().getName()+"--"+Thread.currentThread().getId());
    }

    @RequestMapping("/dummyTest")
    public String action1(){
        System.out.println("DUMMY START"+Thread.currentThread().getName()+"--"+Thread.currentThread().getId());
//        async.show();
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "response";
//        System.out.println("CONTROLLER END"+Thread.currentThread().getName()+"--"+Thread.currentThread().getId());
    }

    @RequestMapping("/dummy")
    public void action(){
        System.out.println("CONTROLLER START"+Thread.currentThread().getName()+"--"+Thread.currentThread().getId());
//        async.show();
        topicService.processAsync();
        System.out.println("CONTROLLER END"+Thread.currentThread().getName()+"--"+Thread.currentThread().getId());
    }

    @RequestMapping("/callApi")
    public void callApi(){

        RestTemplate restTemplate=new RestTemplate();
        String url="http://192.168.88.104:8080/dummy";
        for(int i=0;i<1;i++){
            ResponseEntity<String> responseEntity=restTemplate.getForEntity(url, String.class);
//            System.out.println("value - "+i+"--------->"+responseEntity.getStatusCode());
        }

    }

}
