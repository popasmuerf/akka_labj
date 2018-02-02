package refelction.servletframework.interfaces;

import java.io.IOException;

/**
 * https://www.javaworld.com/article/2076541/java-web-development/building-a-java-servlet-framework-using-reflection--part-1.html
 * Created by mdb on 1/25/18.
 *
 * Interface to controller of our framework....
 *
 *
 */
public interface PresentationInterface {
    public void intializePresentation(ProxyInterface proxy) ;
    public void output(String next)throws IOException;
    public void finalizePresentation() throws IOException ;
}
