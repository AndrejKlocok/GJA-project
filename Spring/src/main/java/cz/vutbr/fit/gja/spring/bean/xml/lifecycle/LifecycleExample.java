package cz.vutbr.fit.gja.spring.bean.xml.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Martin Kocour
 * created on 22/12/2018
 *
 * Example of {@link BeanPostProcessor} and the order of invoked methods.
 * @see LifecycleProcessor
 */
public class LifecycleExample implements InitializingBean, DisposableBean {

    /**
     * Implicit initializing method.
     *
     * @see InitializingBean
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(LifecycleExample.class.getSimpleName() + ": call afterPropertiesSet()");
    }

    /**
     * Implicit destroying method.
     *
     * @see DisposableBean
     */
    @Override
    public void destroy() throws Exception {
        System.out.println(LifecycleExample.class.getSimpleName() + ": call implicit destroy()");
    }
}
