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
        DefaultSubMenu mavenMenu = new DefaultSubMenu("Maven");
        DefaultSubMenu servletsMenu = new DefaultSubMenu("Servlets");
        DefaultSubMenu jspMenu = new DefaultSubMenu("JSP");
        DefaultSubMenu dbMenu = new DefaultSubMenu("JPA_Hibernate");
        DefaultSubMenu rmiMenu = new DefaultSubMenu("RMI");
        DefaultSubMenu jmsMenu = new DefaultSubMenu("JMS");
        DefaultSubMenu primeMenu = new DefaultSubMenu("Primefaces");
        DefaultSubMenu gwtMenu = new DefaultSubMenu("GWT");

        //MAIN
        item = new DefaultMenuItem("Home_Welcome");
        item.setCommand("#{menuView.home_welcome}");
        mainMenu.addElement(item);

        //Maven
        item = new DefaultMenuItem("Introduction");
        item.setCommand("#{menuView.maven_intro}");
        mavenMenu.addElement(item);

        //Servlets
        item = new DefaultMenuItem("Hello");
        item.setCommand("#{menuView.servlets_hello}");
        servletsMenu.addElement(item);

        item = new DefaultMenuItem("Form");
        item.setCommand("#{menuView.servlets_form}");
        servletsMenu.addElement(item);

        //JSP
        item = new DefaultMenuItem("Form");
        item.setCommand("#{menuView.jsp_form}");
        jspMenu.addElement(item);

        item = new DefaultMenuItem("ImageUpload");
        item.setCommand("#{menuView.jsp_imageUpload}");
        jspMenu.addElement(item);

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

        item = new DefaultMenuItem("Criteria");
        item.setCommand("#{menuView.criteria}");
        dbMenu.addElement(item);

        //RMI
        item = new DefaultMenuItem("Client_Server");
        item.setCommand("#{menuView.clientServer}");
        rmiMenu.addElement(item);

        //JMS
        item = new DefaultMenuItem("Point_to_Point");
        item.setCommand("#{menuView.pointToPoint}");
        jmsMenu.addElement(item);

        item = new DefaultMenuItem("Publish_Subscribe");
        item.setCommand("#{menuView.publishSubscribe}");
        jmsMenu.addElement(item);

        //GWT
        item = new DefaultMenuItem("GWT");
        item.setCommand("#{menuView.archetype}");
        item.setCommand("#{menuView.gui}");
        item.setCommand("#{menuView.rpc}");
        gwtMenu.addElement(item);

        model.addElement(mainMenu);
        model.addElement(primeMenu);
        model.addElement(dbMenu);
        model.addElement(rmiMenu);
        model.addElement(jmsMenu);
    }

    public MenuModel getModel() {
        return model;
    }

    //Main Menu
    public String  home_welcome(){ return "/index"; }

    //Maven
    public String  maven_intro(){ return "/ui/jsf/Maven/Introduction"; }

    //Servlets
    public String  servlets_hello(){ return "/ui/jsf/Servlet/Hello"; }

    public String  servlets_form(){ return "/ui/jsf/Servlet/Form"; }

    //JSP
    public String  jsp_form(){ return "/ui/jsf/JSP/Form"; }

    public String  jsp_imageUpload(){ return "/ui/jsf/JSP/ImageUpload"; }

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

    public String criteria() {return "/ui/jsf/JPA_Hibernate/Criteria"; }

    //RMI
    public String  clientServer() { return "/ui/jsf/RMI/Client_Server"; }

    //JMS
    public String  publishSubscribe() { return "/ui/jsf/JMS/Publish_Subscribe"; }

    public String  pointToPoint(){
        return "/ui/jsf/JMS/Point_to_Point";
    }

    //PrimeFaces
    public String inputs(){ return "/ui/jsf/PrimeFaces/Inputs";}

    public String layout(){ return "/ui/jsf/PrimeFaces/Layout";}

    public String menus(){ return "/ui/jsf/PrimeFaces/Menu";}

    public String data(){ return "/ui/jsf/PrimeFaces/Data";}

    public String filesImages(){ return "/ui/jsf/PrimeFaces/Files_Images";}

    public String pr_setUp(){ return "/ui/jsf/PrimeFaces/PrimeFaces_SetUp";}

    //GWT
    public String archetype() { return "/ui/jsf/GWT/Archetype"; }

    public String gui() { return "/ui/jsf/GWT/GUI"; }

    public String rpc() { return "/ui/jsf/GWT/RPC"; }

    // EJB
    public String stateful(){ return "/ui/jsf/EJB/stateful";}
    public String stateless(){ return "/ui/jsf/EJB/stateless";}

    // JSF
    public String jsf_intro(){ return "/ui/jsf/JSF/jsf_intro";}
    public String jsf_examples(){ return "/ui/jsf/JSF/jsf_examples";}
    public String jsf_custom(){ return "/ui/jsf/JSF/jsf_custom";}

    // Testing
    public String junit(){ return "/ui/jsf/testing/junit";}
    public String selenium(){ return "/ui/jsf/testing/selenium";}
}