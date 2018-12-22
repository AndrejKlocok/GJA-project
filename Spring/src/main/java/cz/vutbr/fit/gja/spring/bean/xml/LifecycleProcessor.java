package cz.vutbr.fit.gja.spring.bean.xml;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

/**
 * @author Martin Kocour
 * created on 22/12/2018
 */
public class LifecycleProcessor implements BeanPostProcessor {

    @Override
    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof LifecycleExample) {
            System.out.println("LifecycleProcessor: " + beanName + ": call postProcessBeforeInitialization()");
        }
        return bean;
    }

    @Override
    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof LifecycleExample) {
            System.out.println("LifecycleProcessor: " + beanName + ": call postProcessAfterInitialization()");
        }
        return bean;
    }
}
