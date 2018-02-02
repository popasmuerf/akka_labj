package refelction.servletframework.interfaces;

/**
 * Created by mdb on 1/25/18.
 *
 * The implementor of the ProxyInterface is the single
 * point of contact for all platform-dependent
 * functionality.  The Presentation object
 * does not need to understand the details of
 * implementing the presentation layer.
 *
 * Whether it is through applets, servlets, or sockets..
 * the methods of the interface must be
 * statisfed....
 *
 *
 */
public interface ProxyInterface {
    public DataInterface getDataObject(String name);
    public PresentationInterface getPresentationObject(String name) ;
    public BusinessInterface getBusinessObject(String name);
}
