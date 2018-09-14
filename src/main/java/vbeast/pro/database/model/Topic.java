package vbeast.pro.database.model;

import javax.persistence.*;

/**
 * Created by varun on 7/9/18.
 */

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "descrption")
    private String desc;

    public Topic( String name, String desc) {
//        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "id-"+this.id+" name-"+this.name+" desc-"+this.desc;
    }

}
