package cz.vutbr.fit.bean.EJB.stateful;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 * Stateful Java Bean,
 * trieda Village, je jednoduchým príkladom pre ukážku udržania si stavu,
 * použité pre veľmi jednuduchú "resource managment game".
 *
 * @author  Michal Gabonay
 * @version 1.0
 * @since   2018-12-18
 */
@Stateful (name = "village")
@LocalBean
public class Village {

    private int wood = 0;
    private int stone = 0;

    private int quarry = 1;
    private int lumber = 1;
    private int house = 1;

    private String msg = "";

    /**
     * Táto trieda pridá drevo.
     */
    public void addWood() {
        wood += 10*lumber;
        msg = "Vyťažené " + 10*lumber + " dreva.";
    }

    /**
     * Táto metóda pridá kameň.
     */
    public void addStone() {
        stone += 5*quarry;
        msg = "Vyťažené " + 5*quarry + " kameňa.";
    }

    /**
     * Táto metóda vylepšuje kamenolom, tým že spotrebuje suroviny.
     */
    public void lvlUpQuarry() {
        int wood_price = (quarry*10) + 20;
        int stone_price = (quarry*5) + 10;

        if (wood_price <= wood && stone_price <= stone){
            wood -= wood_price;
            stone -= stone_price;
            quarry++;
            msg = "Kameňolom vylepšený na level " + quarry + " za " + wood_price + " dreva a " + stone_price + "kameňa.";
        } else {
            msg = "Nedostatok surovín! Cena vylepšenia je " + wood_price + " dreva a " + stone_price + "kameňa.";
        }
    }

    /**
     * Táto metóda vylepšuje drevorubača, tým že spotrebuje suroviny.
     */
    public void lvlUpLumber() {
        int wood_price = (lumber*10) + 20;
        int stone_price = (lumber*5) + 10;

        if (wood_price <= wood && stone_price <= stone){
            wood -= wood_price;
            stone -= stone_price;
            lumber++;
            msg = "Drevorubač vylepšený na level " + lumber + " za " + wood_price + " dreva a " + stone_price + "kameňa.";
        } else {
            msg = "Nedostatok surovín! Cena vylepšenia je " + wood_price + " dreva a " + stone_price + "kameňa.";
        }
    }

    /**
     * Táto metóda vylepšuje dom, tým že spotrebuje suroviny.
     */
    public void lvlUpHouse() {
        int wood_price = (house*20) + 50;
        int stone_price = (house*10) + 30;

        if (wood_price <= wood && stone_price <= stone){
            wood -= wood_price;
            stone -= stone_price;
            house++;
            msg = "Dom vylepšený na level " + house + " za " + wood_price + " dreva a " + stone_price + "kameňa.";
        } else {
            msg = "Nedostatok surovín! Cena vylepšenia je " + wood_price + " dreva a " + stone_price + "kameňa.";
        }
    }

    // GETTERS
    public int getWood() {
        return wood;
    }

    public int getStone() {
        return stone;
    }

    public int getQuarry() {
        return quarry;
    }

    public int getLumber() {
        return lumber;
    }

    public int getHouse() {
        return house;
    }

    public String getMsg() {
        return msg;
    }
}
