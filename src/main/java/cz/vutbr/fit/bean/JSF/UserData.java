package cz.vutbr.fit.bean.JSF;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Managed Bean na priklásenie užívateľa, za účelom úkážky tvorby vlastnej komponenty JSF.
 *
 * @author  Michal Gabonay
 * @version 1.0
 * @since   2018-12-16
 */
@ManagedBean(name = "userData", eager = true)
@SessionScoped
public class UserData implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        return "result";
    }
}