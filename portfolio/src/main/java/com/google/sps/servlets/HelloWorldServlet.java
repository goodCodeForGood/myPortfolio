package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson; 
import data.HelloWorld;

@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

    String[] messages = {"I like to learn new skills", 
        "I love to serve the community",
        "I really want to make a positive impact in this world through technology!",
        "I believe computer science has the power to better the world",
        "Badminton is one of my favorite sports",
        "Singing is something I have been doing from a very young age",
        "I successfully ran my high school service club for 4 years, helping various communities, along with my team"};

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String[] textMessage = messages; 
    
    HelloWorld helloWorld = new HelloWorld(textMessage);
    String json = convertToJsonUsingGson(helloWorld);

    response.setContentType("application/json;"); 
    response.getWriter().println(json);
  }

  private String convertToJsonUsingGson(HelloWorld helloWorld) {
    Gson gson = new Gson();
    String json = gson.toJson(helloWorld);
    return json;
  }
}