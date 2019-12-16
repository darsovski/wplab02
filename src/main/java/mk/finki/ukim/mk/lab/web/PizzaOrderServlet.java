package mk.finki.ukim.mk.lab.web;

//import mk.finki.ukim.mk.lab.service.OrderService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/PizzaOrder.do")
public class PizzaOrderServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;

    public PizzaOrderServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        WebContext webContext = new WebContext(req,resp,req.getServletContext());
        String pizzaSize = (String) req.getSession().getAttribute("pizzaSize");
        String pizzaName = (String) req.getSession().getAttribute("pizzaName");
        webContext.setVariable("pizzaSize",pizzaSize);
        webContext.setVariable("pizzaName",pizzaName);
        resp.setContentType("text/html; charset=UTF-8");
        this.springTemplateEngine.process("deliveryInfo.html",webContext,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String clientName = req.getParameter("clientName");
        String clientAddress = req.getParameter("clientAddress");

        session.setAttribute("clientName", clientName);
        session.setAttribute("clientAddress", clientAddress);
        resp.sendRedirect("/Confirmation.do");
    }
}
