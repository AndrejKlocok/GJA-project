package cz.vutbr.fit.gja.spring.bean.xml.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

/**
 * @author Martin Kocour
 * created on 22/12/2018
 *
 * Example of {@link BeanPostProcessor} and the order of invoked methods.
 *
 * @see BeanPostProcessor
 */
public class LifecycleProcessor implements BeanPostProcessor {


    /**
     * This method is called before initialization of a {@link LifecycleExample} bean.
     *
     * @param bean A bean declared in beans.xml.
     * @param beanName A bean identifier.
     * @return The same bean.
     * @throws BeansException in case of errors
     *
     * @see BeanPostProcessor#postProcessBeforeInitialization(Object, String)
     */
    @Override
    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof LifecycleExample) {
            System.out.println("LifecycleProcessor: " + beanName + ": call postProcessBeforeInitialization()");
        }
        return bean;
    }

    /**
     * This method is called after initialization of a {@link LifecycleExample} bean.
     *
     * @param bean A bean declared in beans.xml.
     * @param beanName A bean identifier.
     * @return The same bean.
     * @throws BeansException in case of errors
     *
     * @see BeanPostProcessor#postProcessAfterInitialization(Object, String)
     */
    @Override
    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof LifecycleExample) {
            System.out.println("LifecycleProcessor: " + beanName + ": call postProcessAfterInitialization()");
        }
        return bean;
    }
}
