package vbeast.pro.jsonToObject;

import com.google.gson.Gson;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by varun on 11/9/18.
 */
public class ObjectToJson {


    public String getJsonString(){
        Gson gson=new Gson();
        BigDecimal salary=new BigDecimal(1234.11);
        List<String> skills=new ArrayList<String>();
        skills.add("Table Tennis");
        skills.add("Badminton");
        skills.add("pro in coding");
        Address address=new Address("85","10","B","18","DELHI");
        Staff staff=new Staff("varun bisht",26,salary,skills,address);
        String jsonString=gson.toJson(staff);
//        String jsonString=convertToJsonString(staff);
        System.out.println(jsonString);
        return jsonString;
    }

    private String convertToJsonString(Object o){
        Gson gson=new Gson();
        String jsonString=gson.toJson(o);
        return jsonString;
    }

    public String getJsonStringForList(){
        Gson gson=new Gson();
        BigDecimal salary=new BigDecimal(1234.11);
        List<String> skills=new ArrayList<String>();
        skills.add("Table Tennis");
        skills.add("Badminton");
        skills.add("pro in coding");
        Address address=new Address("85","10","B","18","DELHI");
        List<Staff> staffList=new ArrayList<Staff>();
        Staff staff=null;
        for(int i=0;i<5;i++){
            staff=new Staff("varun bisht #"+i,26,salary,skills,address);
            staffList.add(staff);
        }
        String jsonString=gson.toJson(staffList);
//        String jsonString=convertToJsonString(staffList);
        System.out.println(jsonString);
        return jsonString;
    }

    public static void main(String[] args) {
        ObjectToJson objectToJson=new ObjectToJson();
        objectToJson.getJsonString();
//        objectToJson.getJsonStringForList();
    }
}
