package cz.vutbr.fit.gja.spring;

import cz.vutbr.fit.gja.spring.bean.annotation.Plane;
import cz.vutbr.fit.gja.spring.bean.java.PlaneConfig;
import cz.vutbr.fit.gja.spring.bean.xml.*;
import cz.vutbr.fit.gja.spring.bean.xml.di.Car;
import cz.vutbr.fit.gja.spring.bean.xml.lifecycle.LifecycleExample;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Martin Kocour
 * created on 22/12/2018
 */
public class MainApp {

    private static Logger log = Logger.getLogger(MainApp.class.getSimpleName());

    public static void main(String[] args) {
        System.out.println("\n1. XML based configuration:");
        showXMLBasedConfiguration();
        System.out.println("\n2. Annotation based configuration:");
        showAnnotationBasedConfiguration();
        System.out.println("\n3. Java based configuration:");
        showJavaBasedConfiguration();
    }

    /**
     * XML based configuration.
     *
     * File beans.xml contains bean specification.
     *
     * 1. Hello world show simple usage of spring's beans.
     *
     * 2. Lazy init example shows difference between lazy initialize beans and normal beans.
     *    Normal bean is created after XML configuration is inflated. Lazy bean is inflated when it is called.
     *    In this example we also shows an order of implicit and explicit initialization and destroy methods.
     *
     * 3. Scope example shows difference between prototype and singleton bean.
     */
    private static void showXMLBasedConfiguration() {
        //Expects beans.xml on ClassPath
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //or use File systep XML app context with path to config xml
//        AbstractApplicationContext context = new FileSystemXmlApplicationContext("./src/main/resources/beans.xml");

        System.out.println("\n\ta) Hello world example");
        HelloWorld helloBean = (HelloWorld) context.getBean("helloWorld");
        System.out.println("Your message: " + helloBean.getMessage());

        System.out.println("\n\tb) Lazy init example");
        LazyInitExample lazyBean = (LazyInitExample) context.getBean("lazy");
        LazyInitExample normalBean = (LazyInitExample) context.getBean("normal");

        System.out.println("\n\tc) Scope example");
        ScopeExample prototype1 = (ScopeExample) context.getBean("prototype");
        System.out.println(prototype1.toString());
        ScopeExample prototype2 = (ScopeExample) context.getBean("prototype");
        System.out.println(prototype2.toString());
        ScopeExample singleton1 = (ScopeExample) context.getBean("singleton");
        System.out.println(singleton1.toString());
        ScopeExample singleton2 = (ScopeExample) context.getBean("singleton");
        System.out.println(singleton2.toString());

        System.out.println("\n\td) Lifecycle example");
        LifecycleExample lifecycleBean = (LifecycleExample) context.getBean("lifecycleExample");

        System.out.println("\n\te) Dependency injection example");
        Car car = (Car) context.getBean("car");
        car.getSeat("Left Front").controlHeater(4);
        System.out.println(car.toString());

        System.out.println("\n\tf) Event example");
        context.start();
        HelloWorld helloBean2 = (HelloWorld) context.getBean("helloWorld");
        System.out.println(helloBean2.getMessage());
        context.stop();

        System.out.println("\nDestroy context...");
        context.destroy();
    }

    /**
     * Annotation based configuration
     */
    private static void showAnnotationBasedConfiguration() {
        ApplicationContext context = new ClassPathXmlApplicationContext("annotation-beans.xml");
        Plane plane = (Plane) context.getBean("plane");
        System.out.println(plane.toString());
    }


    private static void showJavaBasedConfiguration() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PlaneConfig.class);
        Plane plane = (Plane) context.getBean("plane1");
        System.out.println(plane.toString());
    }
}
