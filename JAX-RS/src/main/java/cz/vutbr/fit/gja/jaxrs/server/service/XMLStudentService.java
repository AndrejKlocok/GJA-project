package cz.vutbr.fit.gja.jaxrs.server.service;

import cz.vutbr.fit.gja.jaxrs.common.entity.StudentXML;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Martin Kocour
 * created on 03/01/2019
 */
@Path("xml/student")
public class XMLStudentService {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public StudentXML getXMLStudent() {
        StudentXML studentXML = new StudentXML("XMLname", "XMLsurname", "XMLlogin");
        return studentXML;
    }
}
