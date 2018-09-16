package vbeast.pro.aysnc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import vbeast.pro.database.model.Topic;
import vbeast.pro.database.service.TopicService;

/**
 * Created by varun on 12/9/18.
 */

@Service
public class Async {

    private RestTemplate restTemplate;

    public Async(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate=restTemplateBuilder.setConnectTimeout(1).setReadTimeout(1000).build();
    }


    //    @org.springframework.scheduling.annotation.Async
//    public void show(){
////        System.out.println("in show function"+Thread.currentThread().getName()+"--"+Thread.currentThread().getId());
//        Topic topic=new Topic("varun",Thread.currentThread().getName()+"--"+Thread.currentThread().getId());
//        topicService.save(topic);
////        System.out.println("exiting show function"+Thread.currentThread().getName()+"--"+Thread.currentThread().getId());
//    }

    @org.springframework.scheduling.annotation.Async
    public void doBackgroundTask(AsyncInterface asyncInterface,int id){

        long start=System.currentTimeMillis();
        String response=restTemplate.getForObject("http://192.168.88.104:8080/dummyTest",String.class);
        System.out.println(System.currentTimeMillis() -start);
        System.out.println("BACKGROUND START--"+Thread.currentThread().getName()+"--"+Thread.currentThread().getId());
        Topic topic=new Topic("varun",Thread.currentThread().getName()+"--"+Thread.currentThread().getId()+response);
        topic.setId(id);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        asyncInterface.finalExecution(topic);
        System.out.println("BACKGROUND END--"+Thread.currentThread().getName()+"--"+Thread.currentThread().getId());
    }

}
