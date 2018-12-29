<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>JSP ImageUpload</title>
    </head>
    <body>
        <%-- Print error message if error parameter exists. --%>
        <%
            String error = request.getParameter("error");
            if (error != null)
            {
        %>
        <p style="color: red;">
            <% if ("type".equals(error)) { %> Soubor není obrázkem!
            <% } else if ("exists".equals(error)) { %> Soubor na serveru již existuje!
            <% } else if ("missing".equals(error)) { %> Nahrávaný soubor chybí!
            <% } else if ("failed".equals(error)) { %> Nahrávání souboru selhalo!
            <% } else { %> Neznámá chyba!
            <% } %>
        </p>
        <%
            }
        %>

        <%-- Form --%>
        <form action="upload" method="POST" enctype="multipart/form-data">
            <p><input type="file" name="image"></p>
            <p><button type="submit">Odeslat</button></p>
        </form>
    </body>
</html>
