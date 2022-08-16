package com.google.sps;

import java.net.URL;
import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebInfConfiguration;


public class ServerMain {

  public static void main(String[] args) throws Exception {

    Server server = new Server(8080);
    WebAppContext webAppContext = new WebAppContext();
    server.setHandler(webAppContext);

    URL webAppDir = ServerMain.class.getClassLoader().getResource("META-INF/resources");
    webAppContext.setResourceBase(webAppDir.toURI().toString());

    webAppContext.setConfigurations(
        new Configuration[] {
          new AnnotationConfiguration(), new WebInfConfiguration(),
        });

    webAppContext.setAttribute(
        "org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",
        ".*/target/classes/|.*\\.jar");

    ServletHolder defaultServletHolder = webAppContext.addServlet(DefaultServlet.class, "/");
    defaultServletHolder.setInitParameter("cacheControl", "no-store, max-age=0");

    server.start();
    System.out.println("Server started!");

    server.join();
  }
}
