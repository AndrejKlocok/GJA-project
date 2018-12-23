package cz.vutbr.fit.bean.EJB.stateful;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Managed Bean pre použitie vloženia biznis logiky do JSF.
 *
 * @author  Michal Gabonay
 * @version 1.0
 * @since   2018-12-18
 */
@ManagedBean (name = "VillageBean")
@SessionScoped
public class VillageBean {

    @EJB
    private Village village;

    public Village getVillage() {
        return village;
    }
}
