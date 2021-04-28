package calculate.servlet;

import calculate.servlet.entity.User;
import calculate.servlet.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/changePassword", name = "changePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/changePassword.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.getByLogin(((User)req.getSession().getAttribute("user")).getLogin());
        String oldPassword = req.getParameter("oldPassword");
        if(user.getPassword().equals(oldPassword)){
            String newPassword = req.getParameter("newPassword");
            if(newPassword != ""){
                userService.changePassword((User)req.getSession().getAttribute("user"),newPassword);
                req.setAttribute("attempt","Password changed!");
            }else{
                req.setAttribute("attempt","New password error");
            }
        }else{
            req.setAttribute("attempt","Wrong old password");
        }

        getServletContext().getRequestDispatcher("/changePassword.jsp").forward(req,resp);
    }
}
