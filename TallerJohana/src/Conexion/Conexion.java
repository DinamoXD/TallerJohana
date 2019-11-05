package Conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    
      private Connection conexion;
      private Statement statement;

    public Conexion() {
        String url="jdbc:mysql://localhost:3306/tallerjohana";
        String user="root";
        String pass="";
          try {
              Class.forName("com.mysql.jdbc.Driver").newInstance();
              this.conexion=DriverManager.getConnection(url,user,pass);
              this.statement=this.conexion.createStatement();
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
              Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
              Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
      
      
      
   public void cerrarConexion() {
          try {
              getStatement().close();
              getConexion().close();
          } catch (SQLException ex) {
              Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

   public ResultSet consulta(String query) {
       ResultSet r= null;
       
          try {
              r=getStatement().executeQuery(query);
          } catch (SQLException ex) {
              Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
          }
          return r;
       
    }
   
   public boolean querys(String query){
       boolean b=false;
          try {
              b=getStatement().execute(query);
          } catch (SQLException ex) {
              Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
          }
          return b;
   }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
    
}
    
    
    

