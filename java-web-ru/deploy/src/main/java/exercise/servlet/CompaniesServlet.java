package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        PrintWriter out = response.getWriter();
        var searchValue = request.getParameter("search") == null ? "" : request.getParameter("search");
        List<String> result = getCompanies().stream()
                .filter(x -> x.contains(searchValue))
                .toList();
        if (result.isEmpty()) {
            out.println("Companies not found");
            return;
        }
        result.forEach(out::println);
        out.close();
        // END
    }
}
