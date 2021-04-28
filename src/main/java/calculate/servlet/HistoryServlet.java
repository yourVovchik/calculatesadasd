package calculate.servlet;

import calculate.servlet.entity.User;
import calculate.servlet.service.OperationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/history", name = "HistoryServlet")
public class HistoryServlet extends HttpServlet {
    OperationService operationService = new OperationService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("operations",operationService.getOperationHistoryByUser((User)req.getSession().getAttribute("user")));
            getServletContext().getRequestDispatcher("/history.jsp").forward(req, resp);

    }

    @WebServlet(urlPatterns = "/changeName")
    public static class ChangeNameServlet extends HttpServlet {
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            getServletContext().getRequestDispatcher("/changeName.jsp");
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        }
    }
}
