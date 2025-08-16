package com.namansharma.ex_07_Payload_management.Map;

import java.util.*;

public class APITestingComplexJSONTPMAP {

    //{
    //  "fruits": [
    //    {
    //      "name": "Apple",
    //      "color": "#FF0000",
    //      "details": {
    //        "type": "Pome",
    //        "season": "Fall"
    //      },
    //      "nutrients": {
    //        "calories": 52,
    //        "fiber": "2.4g",
    //        "vitaminC": "4.6mg"
    //      }
    //    },
    //  ]
    //}

    public static void main(String[] args) {

        Map<String, Object> payload = new HashMap<>();

        List<LinkedHashMap<String,Object>> fruits = new ArrayList<>();

        //Creating apple
        LinkedHashMap<String,Object> apple = new LinkedHashMap<>();
        apple.put("name","Apple");
        apple.put("colour","#FF0000");

        LinkedHashMap<String, Object> appledetails = new LinkedHashMap<>();
        appledetails.put("type","Pome");
        appledetails.put("season","Fall");
        apple.put("details",appledetails);

        LinkedHashMap<String, Object> applenutrients = new LinkedHashMap<>();
        applenutrients.put("calories","52");
        applenutrients.put("fiber","2.4g");
        applenutrients.put("vitaminC","4.6mg");
        apple.put("nutrients",applenutrients);

        fruits.add(apple);


        //Creating banana
        LinkedHashMap<String,Object> banana = new LinkedHashMap<>();
        banana.put("name","Banana");
        banana.put("colour","#FFFF00");

        LinkedHashMap<String, Object> bananadetails = new LinkedHashMap<>();
        bananadetails.put("type","Berry");
        bananadetails.put("season","Year-round");
        banana.put("details",bananadetails);

        LinkedHashMap<String, Object> banananutrients = new LinkedHashMap<>();
        banananutrients.put("calories","89");
        banananutrients.put("fiber","2.6g");
        banananutrients.put("potassium","358mg");
        banana.put("nutrients",banananutrients);

        fruits.add(banana);

        payload.put("fruits",fruits);
        System.out.println(payload);

    }

}
