<%@ page import="java.io.File" %>
<%@ page import="cz.vutbr.fit.gja.UploadServlet" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>JSP ImageUpload: Uploaded image</title>
    </head>
    <body>
        <%
            String filename = request.getParameter("filename");

            // Parameter missing
            if (filename == null) {
        %>
        <p>Chybí parametr s&nbsp;názvem souboru!</p>
        <%
            }
            // File is not exist
            else if (!new File(config.getServletContext().getRealPath(UploadServlet.DEST_DIR_PATH), filename).exists()) {
        %>
        <p>Soubor <b><%= filename %></b> neexistuje!</p>
        <%
            }
            // It is ok
            else {
        %>
        <p>Váš nahraný obrázek:</p>
        <img src="./<%= request.getParameter("filename") %>" alt="Nahraný obrázek">
        <%
            }
        %>
    </body>
</html>
