package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Patch;

import java.util.List;
import java.util.Map;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.ArrayUtils;

import static java.lang.System.out;

public class UsersServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            showUsers(request, response);
            return;
        }

        String[] pathParts = pathInfo.split("/");
        String id = ArrayUtils.get(pathParts, 1, "");

        showUser(request, response, id);
    }

    public static List<Map<String, String>> getUsers() throws JsonProcessingException, IOException {
        // BEGIN
        Path path = Paths.get("src/main/resources/users.json").toAbsolutePath().normalize();
       // Path path1 = Paths.get("/home/vitaliy25/Hexlet/hexlet-assignments/java-web-ru/html/src/main/resources/users.json");
        String lineFromFile = Files.readString(path);
        //String lineFromFile = Files.readAllLines(path).get(0);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(lineFromFile,
                new TypeReference<>(){});
        // END
    }

    private void showUsers(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException {

        // BEGIN
        List<Map<String, String>> users = getUsers();
        StringBuilder body = new StringBuilder();

        body.append("""
                <!DOCTYPE html>
                <html lang=\"ru\">
                    <head>
                        <meta charset=\"UTF-8\">
                    <title>Example application</title>
                    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\"
                          rel=\"stylesheet\"
                          integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\"
                          crossorigin=\"anonymous\">
                    </head>
                    <body>
                      <table>
                        <tr>
                          <th>ID</th>
                          <th>Full Name</th>
                        </tr>
                """);
        for (Map<String, String> user : users) {
            body.append("   <tr>\n").append("    <td> | ").append(user.get("id")).append(" | </td>\n")
                    .append("       <td>").append("<a ").append("href=\"/users/").append(user.get("id")).
                    append("\">").append(user.get("firstName")).append(" ").append(user.get("lastName"))
                    .append("</a>\n").append(" | </td>\n").append("    </tr>\n");
        }
        body.append("""
                      </table>
                    </body>
                </html>
                """);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out =response.getWriter();
        out.println(body.toString());
        // END
    }

    private void showUser(HttpServletRequest request,
                         HttpServletResponse response,
                         String id)
                 throws IOException {

        // BEGIN
        List<Map<String, String>> users = getUsers();
        StringBuilder body = new StringBuilder();
        var isIdCorrect = false;
        body.append("""
                <!DOCTYPE html>
                <html lang=\"ru\">
                    <head>
                        <meta charset=\"UTF-8\">
                    <title>Example application</title>
                    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\"
                          rel=\"stylesheet\"
                          integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\"
                          crossorigin=\"anonymous\">
                    </head>
                    <body>
                      <table>
                      <caption>Список пользователей</caption>
                        <tr>
                          <th>| ID |</th>
                          <th> Full Name |</th>
                          <th> email |</th>
                        </tr>
                """);
        for (Map<String, String> user : users) {
            if (user.get("id").equals(id)) {
                body.append("   <tr>\n").append("    <td>| ").append(user.get("id")).append(" |</td>\n")
                        .append("       <td>").append(user.get("firstName")).append(" ").append(user.get("lastName"))
                        .append(" |</td>\n").append("       <td> ").append(user.get("email")).append(" | </td>\n")
                        .append("    </tr>\n");
                isIdCorrect = true;
            }
        }
        body.append("""
                      </table>
                    </body>
                </html>
                """);
        if (!isIdCorrect) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out =response.getWriter();
        out.println(body.toString());
        // END
    }
}
