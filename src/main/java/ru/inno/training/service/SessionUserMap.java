package ru.inno.training.service;

import ru.inno.training.pojo.Users;

import java.util.*;

/**
 * Created by mikhail on 28/12/16.
 */
public class SessionUserMap {

    private static Map<String, Users> userSession = new HashMap<>();

    public static boolean isSessionExist(String session){

        Set a = userSession.keySet();
        if(a.contains(session)){
            return true;
        }
        else {
            return false;
        }

    }

    public static void addUserSession(String session, Users user){
        userSession.put(session, user);
    }

    public static void deleteSession(String session){
        userSession.remove(session);
    }

    public static void main(String[] args) {
        SessionUserMap sessionUserMap = new SessionUserMap();
        Users a = new Users("1","2","3","4", false);
        a.setSession("1");

        SessionUserMap.addUserSession("3", a);
        SessionUserMap.addUserSession("1", a);
        System.out.println(userSession.keySet().toString());
        SessionUserMap.deleteSession("3");


        System.out.println(sessionUserMap.isSessionExist("3"));
        System.out.println(sessionUserMap.isSessionExist("1"));

    }

}
