package co.ed.uco.nose.data.dao.impl.sql.postgresql;

import java.sql.Connection;

import co.ed.uco.nose.crosscuting.exception.NoseException;
import co.ed.uco.nose.data.dao.entity.SqlConnection;

public class PostgresDAOFactory {
    private Connection connection;

    protected void openConnection() {
        // Credenciales locales actualizadas
        String url = "jdbc:postgresql://localhost:5432/Doo";  // Base de datos "Doo" en puerto 5432
        String user = "postgres";
        String password = "1023";

        try {
            this.connection = SqlConnection.openConnection(url, user, password);
            System.out.println("Conexión a PostgreSQL local (base de datos 'Doo', esquema 'public') abierta exitosamente.");
        } catch (NoseException e) {
            // Manejo controlado: registre el technicalMessage para depuración
            System.err.println("Error al abrir conexión local: " + e.getUserMessage());
            throw e;  // Re-lanza para manejo superior
        }
    }

    // Resto de métodos (initTransaction, closeConnection, etc.) como se definió previamente
    protected void closeConnection() {
        if (connection != null) {
            SqlConnection.closeConnection(connection);
        }
    }
}