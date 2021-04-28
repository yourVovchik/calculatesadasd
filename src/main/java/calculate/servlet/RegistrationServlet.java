package calculate.servlet;

import calculate.servlet.entity.User;
import calculate.servlet.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(urlPatterns = "/registration", name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = new User(0, login, password, name);
        if(userService.checkCorrectness(user)){
            req.setAttribute("regMessage","Incorrect data");
            getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
        }else{
            if(userService.getByLogin(login) == null){
                if(userService.add(user)){
                    session.setAttribute("user",user);
                    req.setAttribute("regMessage", "Registration successful!");
                }
            }else{
                req.setAttribute("regMessage","Error");
            }
        }


        getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
    }
}
