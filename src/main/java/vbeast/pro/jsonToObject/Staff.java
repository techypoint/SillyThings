package vbeast.pro.jsonToObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by varun on 11/9/18.
 */
public class Staff {

    @SerializedName("new_name_in_json")
    private String name;
    private int age;
    private BigDecimal salary;
    private List<String> skills;
    private Address address;
    private Inner inner;
    @SerializedName("data")
    List<Map<String,String>> mapList=new ArrayList<Map<String, String>>();
    @SerializedName("data1")
    JsonArray jsonArray=new JsonArray();

    public Staff(String name, int age, BigDecimal salary, List<String> skills,Address address) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.skills = skills;
        this.address=address;
        inner=new Inner("inner class converison");

        Map<String,String> stringStringMap=new HashMap<String, String>();
        stringStringMap.put("key1","val1");
        stringStringMap.put("key2","val2");
        Map<String,String> stringStringMap1=new HashMap<String, String>();
        stringStringMap1.put("key3","val3");
        stringStringMap1.put("key4","val4");

        mapList.add(stringStringMap);
        mapList.add(stringStringMap1);

        JsonObject jsonObject=new JsonObject();
        jsonObject.add("dfsdfs",new JsonPrimitive("1111"));
        jsonArray.add(jsonObject);
    }

    static class Inner{
        private String name;

        public Inner(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

}

}