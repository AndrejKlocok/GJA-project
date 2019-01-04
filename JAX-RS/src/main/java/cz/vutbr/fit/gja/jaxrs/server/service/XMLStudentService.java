package cz.vutbr.fit.gja.jaxrs.server.service;

import cz.vutbr.fit.gja.jaxrs.common.entity.StudentXML;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;

/**
 * @author Martin Kocour
 * created on 03/01/2019
 *
 * Example using JAXB server.
 */
@Path("/xml/student")
public class XMLStudentService {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public StudentXML getXMLStudent() {
        StudentXML studentXML = new StudentXML("XMLname", "XMLsurname", "XMLlogin");
        return studentXML;
    }
}
