package refelction.servletframework.interfaces;

import java.util.Hashtable;

/**
 * Created by mdb on 1/25/18.
 *
 *
 *Dynamic business objects loading
 *===================================
 * The Java Reflextion API provides
 * an easy mechanism with
 * which to execute this framework...
 *
 *
 *
 *
 *
 */
public interface BusinessInterface {
    public void init(ProxyInterface proxy, Hashtable parameters)throws Exception ;
}
