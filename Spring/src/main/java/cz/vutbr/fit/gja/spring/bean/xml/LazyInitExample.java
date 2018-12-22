package cz.vutbr.fit.gja.spring.bean.xml;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author Martin Kocour
 * created on 22/12/2018
 */
public class LazyInitExample implements InitializingBean, DisposableBean {

    private String name;

    public LazyInitExample(String name) {
        this.name = name;
    }

    public void init() {
        System.out.println(name + ": Call explicit init()");
    }

    public void finish() {
        System.out.println(name + ": Call explicit destroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(name + ": Call default init()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(name + ": Call default destroy()");
    }
}
