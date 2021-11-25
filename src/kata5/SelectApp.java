package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectApp {

    private Connection connect() {
        String url = "jdbc:sqlite:.\\src\\kata5\\Prueba.db";
        Connection conn = null;
        try {
            //Creamos un objeto Connection para conectarnos a la BD SQLite.
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void selectAll() {
        String url = "jdbc:sqlite:.\\src\\kata5\\Prueba.db";
        String sql = "SELECT * FROM PEOPLE";
        try (Connection conn = this.connect();
                //Creamos una instancia de la clase Statement a partir del objeto Connection.
                Statement stmt = conn.createStatement();
                //Se crea una instancia de la clase ResultSet invocando el método executeQuery() delobjeto Statement. Este método acepta una instrucción SELECT.
                ResultSet rs = stmt.executeQuery(sql)) {
            //Se hace un bucle usando el método next() del objeto ResultSet.
            while (rs.next()) {
                //Finalmente, se usa un método get de ResultSet, como por ejemplo, getInt(),getString(), getDouble(), etc. para obtener en cada iteración los datos.
                System.out.println(rs.getInt("id") + "\t"
                        + rs.getString("Name") + "\t"
                        + rs.getString("Apellidos") + "\t"
                        + rs.getString("Departamento") + "\t");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
