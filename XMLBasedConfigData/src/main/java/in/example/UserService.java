package in.example;

import java.util.List;
//public class UserService {
//private String username;
//    public UserService(String username){
//    this.username = username;
//        System.out.println("UserService Created");
//    }
//    public String getUsername(){
//        return username;
//    }
//}



public class UserService {
//    private List<String> usernames;
//    public UserService(List<String> usernames){
//        this.usernames = usernames;
//        System.out.println("UserService Created");
//    }
//    public List<String> getUsernames(){
//        return usernames;
//    }

public UserService(){
    System.out.println("UserService Created");
}

public void init(){
    System.out.println("Post construct phase ");
}

public void cleanup(){
    System.out.println("Pre Destroy Phase");
}


}