package Filter;

import Utils.StringEscapeUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Map;

public class EscapeWarpper extends HttpServletRequestWrapper {
    public EscapeWarpper(HttpServletRequest servletRequest) {
        super(servletRequest);
    }

    @Override
    public String getParameter(String name) {
        String value = getRequest().getParameter(name);
        return StringEscapeUtil.escapeHtml(value);
    }

    @Override
    public String[] getParameterValues(String name) {
        return super.getParameterValues(name);
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return super.getParameterMap();
    }
}
