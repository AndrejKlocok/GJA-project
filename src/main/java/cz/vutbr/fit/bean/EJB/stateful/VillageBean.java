package cz.vutbr.fit.bean.EJB.stateful;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean (name = "VillageBean")
@SessionScoped
public class VillageBean {

    @EJB
    private Village village;

    public Village getVillage() {
        return village;
    }
}
