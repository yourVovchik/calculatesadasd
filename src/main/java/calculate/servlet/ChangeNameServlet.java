package calculate.servlet;

import calculate.servlet.entity.User;
import calculate.servlet.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/changename",name = "ChangeNameServlet")
public class ChangeNameServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/changeName.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newName = req.getParameter("newName");
        if(newName != ""){
            userService.changeName((User)req.getSession().getAttribute("user"),newName);
            req.setAttribute("attempt","Name changed to " + newName);
        }else{
            req.setAttribute("attempt","Error name");
        }

        getServletContext().getRequestDispatcher("/changeName.jsp").forward(req,resp);
    }
}


