package vbeast.pro.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import vbeast.pro.aysnc.AsyncInterface;
import vbeast.pro.database.model.Topic;
import vbeast.pro.database.repository.TopicRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by varun on 7/9/18.
 */
@Service
public class TopicService implements AsyncInterface {

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    vbeast.pro.aysnc.Async async;


    public List<Topic> getTopics() {
        List<Topic> topicList = new ArrayList();
        Iterable<Topic> topicIterable = topicRepository.findAll();
        Iterator<Topic> topicIterator = topicIterable.iterator();
        while (topicIterator.hasNext()) {
            Topic topic = topicIterator.next();
            topicList.add(topic);
        }
        return topicList;
    }

    public void save(Topic topic){
        System.out.println(topicRepository.hashCode());
       Topic integer= topicRepository.save(topic);
        System.out.println(integer.getId());
    }

    public void processAsync(){
        async.doBackgroundTask(this);
    }

    @Override
    public void finalExecution(Topic topic) {
//        System.out.println("FINAL EXECUTION START--"+Thread.currentThread().getName()+"--"+Thread.currentThread().getId());
        save(topic);
//        System.out.println("FINAL EXECUTION END--"+Thread.currentThread().getName()+"--"+Thread.currentThread().getId());
    }
}
