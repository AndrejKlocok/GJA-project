package cz.vutbr.fit.gja;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * FormServlet demonstrating form processing
 */
@WebServlet(name = "Form", urlPatterns = {"/form"}) // You can write annotation instead of writing it to file web.xml
public class FormServlet extends HttpServlet
{
    /**
     * Writes begging of HTML document
     *
     * @param out Object of PrintWriter
     * @param title Title
     */
    private void writeBegin(PrintWriter out, String title) {
        out.write("<!DOCTYPE html><head><title>");
        out.write(title);
        out.write("</title></head><body>");
    }

    /**
     * Writes end of HTML document
     *
     * @param out Object of PrintWriter
     */
    private void writeEnd(PrintWriter out) {
        out.write("</body></html>");
    }

    /**
     * Writes form to HTML document
     *
     * @param out Object of PrintWriter
     */
    private void writeForm(PrintWriter out) {
        out.write("<form action='form' method='POST'>");
        out.write("<p><label for='form_name'>Jméno</label> <input type='text' id='form_name' name='name'></p>");
        out.write("<p><input type='checkbox' id='form_color_red' name='colors' value='red'> <label for='form_color_red'>Červená</label></p>");
        out.write("<p><input type='checkbox' id='form_color_green' name='colors' value='green'> <label for='form_color_green'>Zelená</label></p>");
        out.write("<p><input type='checkbox' id='form_color_blue' name='colors' value='blue'> <label for='form_color_blue'>Modrá</label></p>");
        out.write("<p><button type='submit'>Odeslat</button></p>");
        out.write("</form>");
    }

    private void writeData(PrintWriter out, HttpServletRequest request) {

        // Write name
        String name = request.getParameter("name");
        out.write("<p>Zadané jméno: ");
        if (name == null || name.trim().isEmpty()) // Parameter missing or is empty
            out.write("<i>nezadáno</i>");
        else
            out.write("<b>" + name + "</b>");
        out.write("</p>");

        // Write colors
        String[] colors = request.getParameterValues("colors");
        out.write("<p>Zadané barvy: ");
        if (colors == null || colors.length == 0)
            out.write("<i>žádné</i>");
        else
            out.write("<b>" + String.join(", ", colors) + "</b>");
        out.write("</p>");
    }

    /**
     * Called by doGet and doPost
     *
     * @param request Request object
     * @param response Response object
     *
     * @throws IOException By PrintWriter
     */
    private void doRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // HTTP method you can detect from request object.
        boolean isPost = request.getMethod().equals("POST");

        // Setting of HTTP header content-type (MIME type of response)
        response.setContentType("text/html;charset=UTF-8");

        // Creation of output stream
        PrintWriter out = response.getWriter();

        // Write document by private methods
        writeBegin(out, "FormServlet");
        if (isPost) // When you put data to GET parameters, it's no effect. If you delete this condition, servlet show parameters from both HTTP method (GET and POST).
            writeData(out, request);
        writeForm(out);
        writeEnd(out);

        // Closing of output stream
        out.close();
    }

    /**
     * Called on HTTP method GET
     *
     * @param request Request object
     * @param response Response object
     *
     * @throws IOException By PrintWriter
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doRequest(request, response);
    }

    /**
     * Called on HTTP method POST
     *
     * @param request Request object
     * @param response Response object
     *
     * @throws IOException By PrintWriter
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doRequest(request, response);
    }
}
