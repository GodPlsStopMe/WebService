import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.SignUpServlet;

public class Main {
    public static void main(String[] args) throws Exception {


        Server server = new Server(8080);
        ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servletContextHandler.addServlet(new ServletHolder(new SignUpServlet()),"/signup");
        server.setHandler(servletContextHandler);
        server.start();
        server.join();
    }
}
