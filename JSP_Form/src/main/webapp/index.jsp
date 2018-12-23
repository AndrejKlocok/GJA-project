<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>JSP Form</title>
    </head>
    <body>
        <%-- This comment IS NOT visible in HTML --%>
        <!-- This comment IS visible in HTML -->

        <%-- Parameter processing and printing --%>
        <% if (request.getMethod().equals("POST")) { %>

        <%-- Name --%>
        <p>
            <%-- Variable "request" is one of available variables in JSP. --%>
            <% String name = request.getParameter("name"); %>
            Zadané jméno:
            <% if (name == null || name.trim().isEmpty()) { %>
            <i>nezadáno</i>
            <% } else { %>
            <b><%= name %></b>
            <% } %>
        </p>

        <%-- Colors --%>
        <p>
            <% String[] colors = request.getParameterValues("colors"); %>
            Zadané barvy:
            <% if (colors == null || colors.length == 0) { %>
            <i>žádné</i>
            <% } else { %>
            <b><%= String.join(", ", colors) %></b>
            <% } %>
        </p>

        <% } %>

        <%-- Form --%>
        <form action="index.jsp" method="POST">
            <p>
                <label for="form_name">Jméno</label>
                <input type="text" id="form_name" name="name">
            </p>
            <p>
                <input type="checkbox" id="form_color_red" name="colors" value="red">
                <label for="form_color_red">Červená</label>
            </p>
            <p>
                <input type="checkbox" id="form_color_green" name="colors" value="green">
                <label for="form_color_green">Zelená</label>
            </p>
            <p>
                <input type="checkbox" id="form_color_blue" name="colors" value="blue">
                <label for="form_color_blue">Modrá</label>
            </p>
            <p>
                <button type="submit">Odeslat</button>
            </p>
        </form>
    </body>
</html>
