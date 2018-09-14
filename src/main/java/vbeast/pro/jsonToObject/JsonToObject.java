package vbeast.pro.jsonToObject;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by varun on 11/9/18.
 */
public class JsonToObject {


    public static void main(String[] args) {

//        JsonArray jsonArray=new JsonArray();
//        JsonObject jsonObject=new JsonObject();
//        jsonObject.add("dfsdfs",new JsonPrimitive("1111"));
//        jsonArray.add(jsonObject);
//        System.out.println(jsonArray);


//        Calendar calendar=GregorianCalendar.getInstance();
//        System.out.println(calendar.getTime());
//        int hr=calendar.get(Calendar.HOUR_OF_DAY);
//        int min=calendar.get(Calendar.MINUTE);
//        System.out.println(Integer.parseInt(hr+""+min));


//        ZoneId z = ZoneId.of("Asia/Kolkata");
//        ZonedDateTime now = ZonedDateTime.now(z);
//        LocalDate tomorrow = now.toLocalDate().plusDays(1);
//        ZonedDateTime tomorrowStart = tomorrow.atStartOfDay(z);
//        Duration duration = Duration.between(now, tomorrowStart);
//        long millisecondsUntilTomorrow = duration.toMillis();



//        ZoneId z = ZoneId.of("Asia/Kolkata");
//        ZonedDateTime now = ZonedDateTime.now(z);
//        ZonedDateTime oneHrFromNow=now.plusHours(1);
//        Duration duration = Duration.between(now, oneHrFromNow);
//        long millisecondsUntilTomorrow = duration.toMillis();
//        System.out.println(millisecondsUntilTomorrow);
//        LocalDate tomorrow = now.toLocalDate().plusDays(1);
//        ZonedDateTime tomorrowStart = tomorrow.atStartOfDay(z);
//
//        Duration duration = Duration.between(now, tomorrowStart);
//        long millisecondsUntilTomorrow = duration.toMillis();
//        System.out.println(millisecondsUntilTomorrow);

//        Class cl=Staff.class;
        ObjectToJson objectToJson=new ObjectToJson();
        String jsonString=objectToJson.getJsonString();
//        String jsonString=objectToJson.getJsonStringForList();
        Gson gson=new Gson();
        Staff staff=null;
         staff=convertJsonToObject(jsonString,Staff.class,staff);
//        Staff staff=gson.fromJson(jsonString, Staff.class);

//        List<Staff> staff = null;
//                staff=convertJsonToObject(jsonString,new TypeToken<List<Staff>>(){}.getType(),staff);
//        List<Staff> staff=gson.fromJson(jsonString,  new TypeToken<List<Staff>>(){}.getType());
        System.out.println(staff);
    }

    public static <T,V> V convertJsonToObject(String jsonString,Type tClass,V returnObj){
        Gson gson=new Gson();
        returnObj= (V) gson.fromJson(jsonString,tClass);
        return returnObj;
    }

}
