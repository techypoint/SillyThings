package vbeast.pro.aysnc;

import org.springframework.scheduling.annotation.*;
import vbeast.pro.database.model.Topic;

/**
 * Created by varun on 13/9/18.
 */
public interface AsyncInterface {


//    void configure();
//    void doBackground();
    void finalExecution(Topic topic);
}
