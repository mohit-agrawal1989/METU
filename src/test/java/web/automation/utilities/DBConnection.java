package web.automation.utilities;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    String dbURL = "jdbc:sqlserver://localhost\\sqlexpress";
    String user = "sa";
    String pass = "secret";

    public void connect(){
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(dbURL, user, pass);
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
