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

        //MAIN
        item = new DefaultMenuItem("Home_Welcome");
        item.setCommand("#{menuView.home_welcome}");
        mainMenu.addElement(item);

        //Primefaces
        item = new DefaultMenuItem("PR_Setup");
        item.setCommand("#{menuView.pr_setup}");
        primeMenu.addElement(item);


        item = new DefaultMenuItem("Inputs");
        item.setCommand("#{menuView.inputs}");
        primeMenu.addElement(item);

        item = new DefaultMenuItem("Layouts");
        item.setCommand("#{menuView.layout}");
        primeMenu.addElement(item);

        item = new DefaultMenuItem("Menus");
        item.setCommand("#{menuView.menus}");
        primeMenu.addElement(item);

        item = new DefaultMenuItem("Data");
        item.setCommand("#{menuView.data}");
        primeMenu.addElement(item);

        item = new DefaultMenuItem("Files_Images");
        item.setCommand("#{menuView.filesImages}");
        primeMenu.addElement(item);

        //JPA_Hibernate
        item = new DefaultMenuItem("DB_SetUP");
        item.setCommand("#{menuView.db_setUp}");
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

    //Main Menu
    public String  home_welcome(){ return "/index"; }

    //JPA_Hibernate
    public String  entity() { return "/ui/jsf/JPA_Hibernate/Entity"; }

    public String  db_setUp(){ return "/ui/jsf/JPA_Hibernate/DB_Setup"; }

    public String  oneToOne(){
        return "/ui/jsf/JPA_Hibernate/OneToOne";
    }

    public String  oneToMany(){
        return "/ui/jsf/JPA_Hibernate/OneToMany";
    }

    public String  crud(){
        return "/ui/jsf/JPA_Hibernate/CRUD";
    }

    public String  query(){
        return "/ui/jsf/JPA_Hibernate/Query";
    }

    public String  hql(){
        return "/ui/jsf/JPA_Hibernate/HQL";
    }

    //PrimeFaces
    public String inputs(){ return "/ui/jsf/PrimeFaces/Inputs";}

    public String layout(){ return "/ui/jsf/PrimeFaces/Layout";}

    public String menus(){ return "/ui/jsf/PrimeFaces/Menu";}

    public String data(){ return "/ui/jsf/PrimeFaces/Data";}

    public String filesImages(){ return "/ui/jsf/PrimeFaces/Files_Images";}

    public String pr_setUp(){ return "/ui/jsf/PrimeFaces/PrimeFaces_SetUp";}
}