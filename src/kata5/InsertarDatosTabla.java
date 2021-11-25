package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public  class InsertarDatosTabla {

    private Connection connect() {
// Cadena de conexión SQLite
        String url = "jdbc:sqlite:.\\src\\kata5\\Prueba.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
// Método para insertar datos en la tabla direcc_email

    public void insert(String email) {
        String sql = "INSERT INTO EMAIL(direccion) VALUES(?)";
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
