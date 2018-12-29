package cz.vutbr.fit.gja.spring.bean.xml;

import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author Martin Kocour
 * created on 22/12/2018
 *
 * This example demonstrates the lifecycle of lazy and normal beans.
 *
 * In beans.xml are declared 2 beans one with lazy-init=true and one with lazy-init="false".
 */
public class LazyInitExample implements InitializingBean, DisposableBean {

    private String name;

    /**
     * Creates a new bean.
     *
     * @param name Name of this bean to distinguish itself.
     */
    public LazyInitExample(String name) {
        this.name = name;
    }

    /**
     * Should be invoked after creation.
     *
     * Explicit initializing method declared in beans.xml
     */
    public void init() {
        System.out.println(name + ": Call explicit init()");
    }

    /**
     * Should be invoked before context is destroyed.
     *
     * Explicit destroying method declared in beans.xml
     */
    public void finish() {
        System.out.println(name + ": Call explicit destroy()");
    }

    /**
     * Invoked by the containing {@code BeanFactory} after it has set all bean properties
     * and satisfied {@link BeanFactoryAware}, {@code ApplicationContextAware} etc.
     * <p>This method allows the bean instance to perform validation of its overall
     * configuration and final initialization when all bean properties have been set.
     * @throws Exception in the event of misconfiguration (such as failure to set an
     * essential property) or if initialization fails for any other reason
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(name + ": Call default init()");
    }


    /**
     * Invoked by the containing {@code BeanFactory} on destruction of a bean.
     * @throws Exception in case of shutdown errors. Exceptions will get logged
     * but not rethrown to allow other beans to release their resources as well.
     */
    @Override
    public void destroy() throws Exception {
        System.out.println(name + ": Call default destroy()");
    }
}
