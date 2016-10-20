package com.ws.spring.configuration;

import com.ws.spring.model.User;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by laowang on 16-10-20.
 */
public class SpringRestTestClient {
    public static final String REST_SERVICE_URI = "http://localhost:8080/test";

    //GET
    @SuppressWarnings("unchecked")
    private static void listAllUsers(){
        System.out.println("Testing listAllUsers API-----------");
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String,Object>> userMap = restTemplate.getForObject(REST_SERVICE_URI+"/user/",List.class);

        if(userMap!=null){
            for(LinkedHashMap<String,Object> map : userMap){
                System.out.println("User : id="+map.get("id")+", Name="+map.get("name")+", Age="+map.get("age")+", Salary="+map.get("salary"));
            }
        }else{
            System.out.println("No user exist-------");
        }
    }

    //GET
    private static void getUser(){
        System.out.println("Testing getUser API---------");
        RestTemplate template = new RestTemplate();
        User user = template.getForObject(REST_SERVICE_URI+"/user/1",User.class);
        System.out.println(user);
    }

    //POST
    private static void createUser(){
        System.out.println("Testing create User API--------");
        RestTemplate template = new RestTemplate();
        User user = new User(0,"Sarah",51,134);
        URI uri = template.postForLocation(REST_SERVICE_URI+"/user/",user,User.class);
        System.out.println("Location : "+uri.toASCIIString());
    }

    //PUT
    private static void updateUser(){
        System.out.println("Testing update User API--------");
        RestTemplate template = new RestTemplate();
        User user = new User(1,"Tomy",33,70000);
        template.put(REST_SERVICE_URI+"/user/1",user);
        System.out.println(user);
    }

    //DELETE
    private static void deleteUser(){
        System.out.println("Testing delete User API------");
        RestTemplate template = new RestTemplate();
        template.delete(REST_SERVICE_URI+"/user/3");
    }

    //DELETE
    private static void deleteAllUsers(){
        System.out.println("Testing all delete Users API--------");
        RestTemplate template = new RestTemplate();
        template.delete(REST_SERVICE_URI+"/user/");
    }

    public static void main(String []args){
        listAllUsers();
        getUser();
        createUser();
        listAllUsers();
        updateUser();
        listAllUsers();
        deleteUser();
        listAllUsers();
        deleteAllUsers();
        listAllUsers();
    }
}
