package blog;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class JettyMain {
    public static void main(String[] args) throws Exception {
        Properties config = loadConfig();
        Server server = new Server(Integer.valueOf(config.getProperty("jetty.port")));

        ServletContextHandler handler = new ServletContextHandler(server, "/blog");
        handler.addServlet(HelloServlet.class, "/");

        server.start();
    }

    private static Properties loadConfig() {
        final String RESOURCES_PATH = "/config.properties";
        final Properties props = new Properties();

        try {
            props.load(JettyMain.class.getResourceAsStream(RESOURCES_PATH));
        } catch(FileNotFoundException ex) {
            new Error("Error during fetching configuration.", ex).printStackTrace();
        } catch(IOException ex) {
            new Error("Error during fetching configuration.", ex).printStackTrace();
        }

        return props;
    }
}