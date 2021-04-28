package calculate.servlet;

import calculate.servlet.entity.User;
import calculate.servlet.service.OperationService;
import calculate.servlet.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/authorization", name = "AuthorizationServlet")
public class AuthorizationServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/authorization.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = userService.getByLogin(login);
        if(user != null){
            if(user.getPassword().equals(password)){
                req.getSession().setAttribute("user",user);
                req.setAttribute("checkAccount","Welcome again");
                getServletContext().getRequestDispatcher("/calculate");
            }else{
                req.setAttribute("checkAccount","Error");
            }
        }else{
            req.setAttribute("checkAccount","User not fount");
        }
        getServletContext().getRequestDispatcher("/authorization.jsp").forward(req,resp);
    }
}
