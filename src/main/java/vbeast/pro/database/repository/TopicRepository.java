package vbeast.pro.database.repository;


import org.springframework.data.repository.CrudRepository;
import vbeast.pro.database.model.Topic;

/**
 * Created by varun on 7/9/18.
 */
public interface TopicRepository extends CrudRepository<Topic,Integer> {
}
