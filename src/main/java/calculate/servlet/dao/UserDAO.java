package calculate.servlet.dao;

import calculate.servlet.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static List<User> users = new ArrayList<>();
    private static int incId = 1;

    public void save(User user){
        user.setId(incId++);
        users.add(user);
    }

    public User getByLogin(String login){
        for(User user : users){
            if(user.getLogin().equals(login))
                return user;
        }
        return null;
    }

    public boolean containsByLogin(String login){
        for(User user : users){
            if(user.getLogin().equals(login))
                return true;
        }
        return false;
    }

    public void changeName(User user, String newName){
        User user1 = getByLogin(user.getLogin());
        user1.setUsername(newName);
    }

    public void changePassword(User user, String newPassword){
        User user1 = getByLogin(user.getLogin());
        user1.setPassword(newPassword);
    }



}
