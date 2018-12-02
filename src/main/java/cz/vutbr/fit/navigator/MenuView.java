package cz.vutbr.fit.navigator;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;


@ManagedBean
public class MenuView {

    private MenuModel model;

    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();

        DefaultMenuItem item;

        DefaultSubMenu mainMenu = new DefaultSubMenu("Main");
        DefaultSubMenu dbMenu = new DefaultSubMenu("JPA_Hibernate");
        DefaultSubMenu primeMenu = new DefaultSubMenu("Primefaces");

        item = new DefaultMenuItem("Home_Welcome");
        item.setCommand("#{menuView.home_welcome}");
        mainMenu.addElement(item);

        item = new DefaultMenuItem("Home_SetUP");
        item.setCommand("#{menuView.home_setUp}");
        mainMenu.addElement(item);

        item = new DefaultMenuItem("Inputs");
        item.setCommand("#{menuView.inputs}");
        mainMenu.addElement(item);

        item = new DefaultMenuItem("Entity");
        item.setCommand("#{menuView.entity}");
        dbMenu.addElement(item);

        item = new DefaultMenuItem("OneToOne");
        item.setCommand("#{menuView.oneToOne}");
        dbMenu.addElement(item);

        item = new DefaultMenuItem("OneToMany");
        item.setCommand("#{menuView.oneToMany}");
        dbMenu.addElement(item);

        item = new DefaultMenuItem("CRUD");
        item.setCommand("#{menuView.crud}");
        dbMenu.addElement(item);

        item = new DefaultMenuItem("Query");
        item.setCommand("#{menuView.query}");
        dbMenu.addElement(item);

        item = new DefaultMenuItem("HQL");
        item.setCommand("#{menuView.hql}");
        dbMenu.addElement(item);

        model.addElement(mainMenu);
        model.addElement(primeMenu);
        model.addElement(dbMenu);
    }

    public MenuModel getModel() {
        return model;
    }

    public String  entity() { return "/ui/jsf/Entity"; }

    public String  oneToOne(){
        return "/ui/jsf/OneToOne";
    }

    public String  oneToMany(){
        return "/ui/jsf/OneToMany";
    }

    public String  crud(){
        return "/ui/jsf/CRUD";
    }

    public String  query(){
        return "/ui/jsf/Query";
    }

    public String  hql(){
        return "/ui/jsf/HQL";
    }

    public String  home_welcome(){ return "/index"; }

    public String  home_setUp(){ return "/ui/jsf/Home_Setup"; }

    public String inputs(){ return "/ui/jsf/Inputs";}
}