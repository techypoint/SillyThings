package vbeast.pro.aysnc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vbeast.pro.database.model.Topic;
import vbeast.pro.database.service.TopicService;

/**
 * Created by varun on 12/9/18.
 */

@Component
public class Async {

//    @org.springframework.scheduling.annotation.Async
//    public void show(){
////        System.out.println("in show function"+Thread.currentThread().getName()+"--"+Thread.currentThread().getId());
//        Topic topic=new Topic("varun",Thread.currentThread().getName()+"--"+Thread.currentThread().getId());
//        topicService.save(topic);
////        System.out.println("exiting show function"+Thread.currentThread().getName()+"--"+Thread.currentThread().getId());
//    }

    @org.springframework.scheduling.annotation.Async
    public void doBackgroundTask(AsyncInterface asyncInterface){
//        System.out.println("BACKGROUND START--"+Thread.currentThread().getName()+"--"+Thread.currentThread().getId());
        Topic topic=new Topic("varun",Thread.currentThread().getName()+"--"+Thread.currentThread().getId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        asyncInterface.finalExecution(topic);
//        System.out.println("BACKGROUND END--"+Thread.currentThread().getName()+"--"+Thread.currentThread().getId());
    }

}
