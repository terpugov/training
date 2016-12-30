package ru.inno.training.service;

import ru.inno.training.pojo.Users;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by mikhail on 30/12/16.
 */
public class SessionAdminMap {

    private static Map<String, Users> adminSession = new HashMap<>();

    public static boolean isSessionExist(String session){

        Set a = adminSession.keySet();
        if(a.contains(session)){
            return true;
        }
        else {
            return false;
        }

    }

    public static void addAdminSession(String session, Users user){
        adminSession.put(session, user);
    }

    public static void deleteSession(String session){
        adminSession.remove(session);
    }

    public static void main(String[] args) {
        SessionUserMap sessionUserMap = new SessionUserMap();
        Users a = new Users("1","2","3","4", false);
        a.setSession("1");

        SessionAdminMap.addAdminSession("3", a);
        SessionAdminMap.addAdminSession("1", a);
        System.out.println(adminSession.keySet().toString());
        SessionUserMap.deleteSession("3");


        System.out.println(sessionUserMap.isSessionExist("3"));
        System.out.println(sessionUserMap.isSessionExist("1"));

    }

}
