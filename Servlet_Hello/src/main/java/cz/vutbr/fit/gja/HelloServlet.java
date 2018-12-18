package cz.vutbr.fit.gja;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * HelloServlet for protocol HTTP
 * Prints text "Hello world!"
 */
public class HelloServlet extends HttpServlet
{
    // Class must override at least one method of doGet, doPost, doPut or doDelete.
    // These methods correspond to HTTP methods GET, POST, PUT and DELETE.

    // Called on HTTP method GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Setting of HTTP header content-type (MIME type of response)
        response.setContentType("text/html;charset=UTF-8");

        // Creation of output stream
        PrintWriter out = response.getWriter();

        // Writing is same like for any output stream, e.g. System.out
        // In practice, you must write whole HTML document including DOCTYPE and tags <html>, <head> and <body>.
        out.write("<p>Hello world!</p>");

        // Closing of output stream
        out.close();
    }
}
