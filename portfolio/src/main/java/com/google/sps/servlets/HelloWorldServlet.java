package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// I added Gson library dependency to pom.xml beforehand, but 
// I had to still import it here
import com.google.gson.Gson; 

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

    String[] messages = {"I like to learn new skills", 
        "I love to serve the community",
        "I believe computer science has the power to better the world",
        "Badminton is one of my favorite sports",
        "Singing is something I have been doing from a very young age",
        "I successfully ran my high school service club for 4 years, helping various communities, along with my team"};

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // response.setContentType("text/html;");
    // response.getWriter().println("Hello Sahiti!");

    // Convert the array of messages to JSON

    HelloWorldServlet helloWorld = new HelloWorldServlet();
    String json = convertToJsonUsingGson(helloWorld);

    // Send the JSON as the response
    response.setContentType("application/json;"); // correct? or jsonText
    response.getWriter().println(json);
  }

   /**
   * Converts a ServerStats instance into a JSON string using the Gson library. Note: We first added
   * the Gson library dependency to pom.xml.
   */
  // instead of param: HelloWorldServlet messageList..
  private String convertToJsonUsingGson(HelloWorldServlet helloWorld) {
    Gson gson = new Gson();
    String json = gson.toJson(helloWorld);
    return json;
  }
}
