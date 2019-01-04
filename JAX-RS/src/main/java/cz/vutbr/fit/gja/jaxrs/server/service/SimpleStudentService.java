package cz.vutbr.fit.gja.jaxrs.server.service;

import cz.vutbr.fit.gja.jaxrs.common.entity.Student;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * @author Martin Kocour
 * created on 03/01/2019
 */
@Path("/simple/student")
public class SimpleStudentService {

    /**
     * Create simple object and return it as plain text.
     *
     * Use GET HTTP method to access this resource.
     * Full path: /rest/simple/student.
     *
     * @return plain text
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getStudent() {
        Student student = new Student("Martin", "Kocour", "xkocou08");
        return student.toString();
    }

    /**
     * Create simple object from matrix parameters.
     *
     * Use GET HTTP method to access this resource.
     * Full path with query params: /rest/simple/student/matrix
     *
     * @param forename Student's forename
     * @param surname Student's surname
     * @param login Student's login
     * @return plain text
     */
    @GET
    @Path("/matrix")
    @Produces(MediaType.TEXT_PLAIN)
    public String getStudentByMatrixParam(@MatrixParam("forename") String forename,
                              @MatrixParam("login") String login,
                              @MatrixParam("surname") String surname) {
        Student student = new Student(forename, surname, login);
        return student.toString();
    }

    /**
     * Create simple object from query parameters.
     *
     * Use GET HTTP method to access this resource.
     * Full path with query params: /rest/simple/student/query
     *
     * @param forename Student's forename
     * @param surname Student's surname
     * @param login Student's login
     * @return plain text
     */
    @GET
    @Path("/query")
    @Produces(MediaType.TEXT_PLAIN)
    public String getStudentByQueryParam(@DefaultValue("Default Name") @QueryParam("forename") String forename,
                                          @DefaultValue("Default login") @QueryParam("login") String login,
                                          @DefaultValue("Default surname") @QueryParam("surname") String surname) {
        Student student = new Student(forename, surname, login);
        return student.toString();
    }

    /**
     * Create simple object from path parameter.
     *
     * @param login Student's login
     * @return plain text
     */
    @GET
    @Path("/{login}/{surname}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getStudentByName(@PathParam("login") String login, @PathParam("surname") String surname) {
        Student student = new Student();
        student.setLogin(login);
        student.setSurname(surname);
        return student.toString();
    }

    /**
     * Add student with POST method.
     *
     * @param forename Student's forename
     * @param surname Student's surname
     * @param login Student's login
     * @return plain text
     */
    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    public String addStudent(@FormParam("forename") String forename,
                             @FormParam("login") String login,
                             @FormParam("surname") String surname) {
        Student student = new Student(forename, surname, login);
        return student.toString();
    }

    /**
     * Redirect GET HTTP request to /simple/student/xhulec01/hulec.
     *
     * @param response
     * @return
     * @throws IOException
     */
    @GET
    @Path("/redirect")
    @Produces(MediaType.TEXT_PLAIN)
    public String redirect(@Context HttpServletResponse response) throws IOException {
        response.sendRedirect("xhulec01/hulec"); // Try to change path
        return "Redirecting...";
    }
}
