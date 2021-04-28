package calculate.servlet.service;

import calculate.servlet.dao.UserDAO;
import calculate.servlet.entity.User;

public class UserService {
    private final UserDAO userDAO = new UserDAO();

    public boolean add(User user){
        if(userDAO.containsByLogin(user.getLogin()))
            return false;
        userDAO.save(user);
        return true;
    }

    public User getByLogin(String login){
        if(userDAO.containsByLogin(login)){
            return userDAO.getByLogin(login);
        }
        return null;
    }

    public boolean checkCorrectness(User user){
        if(user.getLogin() == "" || user.getUsername() == "" || user.getPassword() == ""){
            return true;
        }
        return false;
    }

    public void changeName(User user,String newName){
        userDAO.changeName(user,newName);
    }

    public void changePassword(User user, String newPassword){
        userDAO.changePassword(user,newPassword);
    }

}
