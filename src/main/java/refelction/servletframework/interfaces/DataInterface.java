package refelction.servletframework.interfaces;

/**
 *
 * https://www.javaworld.com/article/2076541/java-web-development/building-a-java-servlet-framework-using-reflection--part-1.html
 *
 * Created by mdb on 1/25/18.
 * We can define what we want to do like we did
 * back in our C++ days within interfaces
 * or Abstract classes...(but in C++ this took
 * the form mostly .h and  .h impliemntation files
 */
public interface DataInterface {
    public void initializeDataObject() ;
    public void beginTransaction() ;
    public void commitTransaction() ;
    public void rollBackTransAction() ;
    public void executeSQL(String sqlStr);
}
