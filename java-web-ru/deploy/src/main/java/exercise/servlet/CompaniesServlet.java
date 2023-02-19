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
        StringBuilder res = new StringBuilder();
        if (queryString == null || !queryString.contains("search")) {
            for (String item : getCompanies()) {
                    res.append(item).append("\n");
                }
            out.println(res);
            out.close();
        } else {
            var searchValue = request.getParameter("search");
            var errorMassageSwitch = true;
            for (String item : getCompanies()) {
                if (item.contains(searchValue)) {
                    res.append(item).append("\n");
                    errorMassageSwitch = false;
                }
            }
            if (errorMassageSwitch) {
                res.append("Companies not found");
            }
            out.println(res.toString());
            out.close();
        }
        // END
    }
}
