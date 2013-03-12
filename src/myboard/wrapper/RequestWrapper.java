package myboard.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Created by bungubbang
 * Email: bungubbang57@gmail.com
 */
public class RequestWrapper extends HttpServletRequestWrapper {
    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Object getAttribute(String name) {
        System.out.println("name = [" + name + "]");
        return super.getAttribute(name);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void setAttribute(String name, Object o) {
        System.out.println("name = [" + name + "], o = [" + o + "]");
        super.setAttribute(name, o);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
