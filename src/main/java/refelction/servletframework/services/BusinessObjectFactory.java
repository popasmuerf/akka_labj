package refelction.servletframework.services;

import refelction.servletframework.interfaces.BusinessInterface;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

/**
 * Created by mdb on 1/25/18.
 * https://www.javaworld.com/article/2076541/java-web-development/building-a-java-servlet-framework-using-reflection--part-1.html
 */
public class BusinessObjectFactory {
    private final String  BUSINESS_OBJECT = "biz object";

    BusinessInterface loadBusinessObject(String actionName){
        BusinessInterface businessInterface = null ; //replace with Optional when you get a chance...
        /**
         * This method is contained in the:
         *      - BusinessObjectFactory
         * class and dynamically loads the business object based upon the action
         * name provided by the proxy.  This method attempts to load
         * the business object and, if any exceptions
         * occur, willcreate an object to handle the error conditions.
         *
         * It assumes a default constructor for this example, but can be tailored
         * to suit any development efforts as needed.
         *
         *
         * The tow main benefits to loading business objects dynamically with this scheme
         * are that you can avoid a registration step and can add functionality to
         * the application ont he fly.  Both of these advantages stem from teh fact that there is
         * no need to specifically hardcode the possible action contained in the servlet.
         */
        try{
            Class _class = Class.forName(actionName + BUSINESS_OBJECT);
            Class[] parameterTypes = new Class[0] ;
            Object[] initArgs = new Object[0] ;
            Constructor constructor = _class.getConstructor(parameterTypes);
            businessInterface = (BusinessInterface) constructor.newInstance(initArgs);
        }catch(Exception e){

        }


        return businessInterface ;
    }

}
