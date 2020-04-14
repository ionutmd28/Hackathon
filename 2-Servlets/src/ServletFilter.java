
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class ServletFilter implements javax.servlet.Filter {

    @Override
    public void init(final FilterConfig filterConfig) {
        filterConfig.getServletContext();
    }

    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException, ServletException {
        final String value = servletRequest.getParameter("val");
        final String index = "index.jsp";
        if (value != null && value.equals("Go back!")) {
            servletRequest.getRequestDispatcher(index).forward(servletRequest, servletResponse);
        } else if (value == null) {
            servletRequest.getRequestDispatcher(index).forward(servletRequest, servletResponse);
        } else {
            servletRequest.getRequestDispatcher("servletEx").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
