package calculate.servlet;

import calculate.servlet.entity.User;
import calculate.servlet.service.OperationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/calculate", name = "CalculateServlet")
public class CalculateServlet extends HttpServlet {
    private OperationService operationService = new OperationService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/calculate.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String a = req.getParameter("a");
        String b = req.getParameter("b");
        String mark = req.getParameter("mark");
        if(operationService.checkMark(mark)){
            double answer = operationService.countUp(a,b,mark,(User)session.getAttribute("user"));
            req.setAttribute("answer", answer);
        }else{
            req.setAttribute("answer","Incorrect mark");
        }
        getServletContext().getRequestDispatcher("/calculate.jsp").forward(req, resp);
    }
}
