package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
        var queryString = request.getQueryString();
        if (queryString == null || !queryString.contains("search")) {
            out.println(getCompanies());
            out.close();
        } else {
            var searchValue = request.getParameter("search");
            for (String item : getCompanies()) {
                if (item.contains(searchValue)) {
                    out.println(item);
                }
            }
            out.close();
        }
        // END
    }
}
