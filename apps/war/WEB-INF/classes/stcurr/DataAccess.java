package stcurr;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import weblogic.jndi.Environment;

public class DataAccess {
	
    // Use JNDI to connect to the data source 
    // under WebLogic Server
    private final String dsname = "datasource1";

    // Use the getInitialJNDIContext() method to open the context and retrieve the datasource
    // by name, create a connection object and return it.
    public Connection getConnection() {
        Connection con = null;

        try {
            // Get the local initial context
        	Context ctx = new InitialContext();
        	// look up the data source by its name
            DataSource ds = (DataSource) ctx.lookup(dsname);
            // ask the data source for a connection
            con = ds.getConnection();

        } catch (Exception e) {
            System.out.println("Connection to pool failed! - " + e);
        } 
        return con;

    }
    
}
