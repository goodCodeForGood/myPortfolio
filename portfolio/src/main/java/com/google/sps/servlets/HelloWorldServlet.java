package com.google.sps.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson; 
//import com.google.sps.data.HelloWorld;
import main.java.data.HelloWorld;


@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

    String[] messages = {"I like to learn new skills", 
        "I love to serve the community",
        "I really want to make a positive impact in this world through technology!",
        "I believe computer science has the power to better the world",
        "Badminton is one of my favorite sports",
        "Singing is something I have been doing from a very young age",
        "I successfully ran my high school service club for 4 years, helping various communities, along with my team"};

    // {
    //     ArrayList<String> messagesList = new ArrayList<>();
    //     messagesList.add("I am passionate to learn and apply computer science skills");
    //     messagesList.add("I love to serve the community");
    //     messagesList.add("I believe computer science has the power to better the world");
    // }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String[] textMessage = messages; // ... messages
    
    // Convert the array of messages to JSON
    HelloWorld helloWorld = new HelloWorld(textMessage);
    String json = convertToJsonUsingGson(helloWorld);

    // Send the JSON as the response
    response.setContentType("application/json;"); 
    response.getWriter().println(json);
  }

  private String convertToJsonUsingGson(HelloWorld helloWorld) {
    Gson gson = new Gson();
    String json = gson.toJson(helloWorld);
    return json;
  }
}