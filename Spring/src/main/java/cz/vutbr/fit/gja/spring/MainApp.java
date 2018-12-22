package cz.vutbr.fit.gja.spring;

import cz.vutbr.fit.gja.spring.bean.HelloWorld;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Martin Kocour
 * created on 22/12/2018
 */
public class MainApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        HelloWorld bean = (HelloWorld) context.getBean("helloWorld");
        bean.getMessage();
    }
}
