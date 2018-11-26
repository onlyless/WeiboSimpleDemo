package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {
        "/logout.do","/member.jsp","/message.do","/logout.jsp","/verify.do","/delete.do","/fans.do","/follows.do"
},initParams = {
        @WebInitParam(name="LOGIN_VIEW",value = "index.jsp")
})
public class MemberFilter implements Filter {
    private String LOGIN_VIEW;
    @Override
    public void init(FilterConfig filterConfig){
        LOGIN_VIEW = filterConfig.getInitParameter("LOGIN_VIEW");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        if(request.getSession().getAttribute("login")!=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            HttpServletResponse response = (HttpServletResponse)servletResponse;
            response.sendRedirect(LOGIN_VIEW);
        }
    }

    @Override
    public void destroy() {
    }
}
