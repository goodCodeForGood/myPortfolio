package main.java.com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    // String textValue = request.getParameter("text-input");
    String textValue = getParam(request, "text-input", "");

    // Print the value so you can see it in the server logs.
    System.out.println("You submitted: " + textValue);

    // view logs in Google Cloud's Logs Explorer tab :)
    // It shows info about "each request sent to your server, 
    // including any logs you've printed"

    // Write the value to the response so the user can see it.
    // response.getWriter().println("You submitted: " + textValue);
    response.setContentType("form-handler/html;");

    response.sendRedirect("https://shibane-sps-summer22.appspot.com/");
  }

   /**
   * @return the request parameter, or the default value if the parameter
   *         was not specified by the client
   * 
   * I got this from the TextProcessorServlet.java file from walkthrough
   */
  private String getParam(HttpServletRequest request, String name, String defaultValue) {
    String value = request.getParameter(name);
    if (value == null) {
      return defaultValue;
    }
    return value;
  }

}
