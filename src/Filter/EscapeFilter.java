package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class EscapeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig){
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = new EscapeWarpper((HttpServletRequest) servletRequest);
        filterChain.doFilter(request,servletResponse);
    }

    @Override
    public void destroy() {
    }
}
