

package in.example.service;

import in.example.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    private Map<Integer, User> userDB;

    public UserService() {
        userDB = new HashMap<>();
    }

    public User createUser(User userReq) {
        userDB.put(userReq.getId(), userReq);
        return userReq;
    }

    public List<User> getAllUsers() {

        List<User> usersResp = new ArrayList<>();

        for(User user : userDB.values())  {
            usersResp.add(user);
        }

        return usersResp;
    }

    public User getUserById(Integer id) {
        return userDB.getOrDefault(id, null);
    }


    public User updateUser(User userReq) {

        if (!userDB.containsKey(userReq.getId())) {
            return null;
        }

        userDB.put(userReq.getId(), userReq);
        return userReq;
    }


    public User deleteUser(Integer id) {

        if (!userDB.containsKey(id)) {
            return null;
        }

        return userDB.remove(id);
    }



}

















//package in.example.service;
//
//import in.example.model.User;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class UserService {
//
//    private Map<Integer,User> userDb ;
//    public UserService() {
//        userDb = new HashMap<>();
//    }
//
//public User createUser(User userReq){
//        userDb.put(userReq.getId() ,userReq);
//        return userReq;
//}
//
//    public List<User> getAllUsers(){
////    return (List<User>) userDb.values();   wrong casting
//        List<User> users = new ArrayList<>();
//        for (User user : userDb.values()){
//            users.add(user);
//        }
//        return users;
//
//    }
//
//public User getUserById(Integer id){
//
//return userDb.get(id);
//
//}
//
////    public User updateUser(User userReq) {
////
////        if (!userDb.containsKey(userReq.getId())) {
////            return null;
////        }
////
////        userDb.put(userReq.getId(), userReq);
////
////        return userReq;
////    }
////
////    public User deleteUser(Integer id) {
////
////        if (!userDb.containsKey(id)) {
////            return null;
////        }
////
////        return userDb.remove(id);
////    }
////
//
//}
