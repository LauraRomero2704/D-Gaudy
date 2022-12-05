package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Laura
 */
public class ConexionDB {

    // Declarar Variables
    private String driver, userDB, passwordDB, database, urlDB;

    // Objeto del elemento conexion, es el que almacena la conexion
    private Connection conexion;

    // Metodo Constructor
    public ConexionDB() {
        // Asignar valores 
        driver = "com.mysql.jdbc.Driver";
        userDB = "root";
        passwordDB = "";
        database = "dbgaudy";
        urlDB = "jdbc:mysql://localhost:3306/" + database;

        // Conectarse
        try {
            // Crear una nueva instancia del driver
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(urlDB, userDB, passwordDB);
            System.out.println("¡Conexión exitosa!");
        } catch (Exception e) {
            System.out.println("Error al conectarse" + e.toString());
        }
    }

    // Metodos tipo objeto 
    public Connection obtenerConexion() {
        return conexion;
    }

    public Connection cerrarConexion() throws SQLException {
        conexion.close();
        conexion = null;
        return conexion;
    }

    public static void main(String[] args) {
        new ConexionDB();
    }
}
