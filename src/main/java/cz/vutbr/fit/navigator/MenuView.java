package cz.vutbr.fit.navigator;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


@ManagedBean
public class MenuView {

    private MenuModel model;

    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();

        DefaultMenuItem item;

        //Second submenu
        DefaultSubMenu secondSubmenu = new DefaultSubMenu("Dynamic Actions");

        item = new DefaultMenuItem("Home_Welcome");
        item.setCommand("#{menuView.home_welcome}");
        secondSubmenu.addElement(item);

        item = new DefaultMenuItem("Home_SetUP");
        item.setCommand("#{menuView.home_setUp}");
        secondSubmenu.addElement(item);

        item = new DefaultMenuItem("Entity");
        item.setCommand("#{menuView.entity}");
        secondSubmenu.addElement(item);

        item = new DefaultMenuItem("OneToOne");
        item.setCommand("#{menuView.oneToOne}");
        secondSubmenu.addElement(item);

        item = new DefaultMenuItem("OneToMany");
        item.setCommand("#{menuView.oneToMany}");
        secondSubmenu.addElement(item);


        item = new DefaultMenuItem("CRUD");
        item.setCommand("#{menuView.crud}");
        secondSubmenu.addElement(item);

        item = new DefaultMenuItem("Query");
        item.setCommand("#{menuView.query}");
        secondSubmenu.addElement(item);

        item = new DefaultMenuItem("HQL");
        item.setCommand("#{menuView.hql}");
        secondSubmenu.addElement(item);

        model.addElement(secondSubmenu);
    }

    public MenuModel getModel() {
        return model;
    }

    public String  entity() {
        return "/ui/jsf/Entity"; }

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

    public String  home_welcome(){

        return "/index";
    }

    public String  home_setUp(){

        return "/ui/jsf/Home_Setup";
    }
}