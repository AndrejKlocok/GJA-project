package cz.vutbr.fit.gja.spring.bean.xml.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author Martin Kocour
 * created on 22/12/2018
 */
public class LifecycleExample implements InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(LifecycleExample.class.getSimpleName() + ": call afterPropertiesSet()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(LifecycleExample.class.getSimpleName() + ": call implicit destroy()");
    }
}
