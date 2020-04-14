import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servletEx")
public class Servlet extends javax.servlet.http.HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        final String value = request.getParameter("val");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><head>");
            out.println("<title>MyTestServlet</title>");
            out.println("</head><body>");
            out.println("<h1>This is a test for the servlet and the value that you introduced before was:<i>" + value + " </i>.</h1>");
            out.println("</body></html>");
        }
    }

}
