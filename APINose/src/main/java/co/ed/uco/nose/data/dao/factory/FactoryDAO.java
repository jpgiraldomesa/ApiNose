package co.ed.uco.nose.data.dao.factory;

import java.sql.Connection;
import java.sql.SQLException;

import co.ed.uco.nose.crosscuting.exception.NoseException;
import co.ed.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.ed.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.ed.uco.nose.data.dao.entity.CityDAO;
import co.ed.uco.nose.data.dao.entity.CountryDAO;
import co.ed.uco.nose.data.dao.entity.DocumentTypeDAO;
import co.ed.uco.nose.data.dao.entity.StateDAO;
import co.ed.uco.nose.data.dao.entity.UserDAO;
import co.ed.uco.nose.data.dao.factory.postgresql.PostgreSqlDAOFactory;

/**
 * Fábrica abstracta para DAOs, gestionando conexión y transacciones.
 * Subclases implementan DAOs específicos (e.g., PostgreSQL).
 */
public abstract class FactoryDAO {
    
	protected static FactoryEnum factory = FactoryEnum.POSTGRESQL;
	
    protected Connection connection;
    
    
    protected static FactoryEnum factory = FactoryEnum.POSTGRESQL;
    /**
     * Obtiene una instancia de fábrica basada en el enum especificado.
     * @param factoryEnum El tipo de fábrica (e.g., POSTGRESQL).
     * @return Instancia de FactoryDAO correspondiente.
     */
    public static FactoryDAO getFactory() {
        switch (factory) {
            case POSTGRESQL:
                return new PostgreSqlDAOFactory();
            default:
                final String userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
                final String technicalMessage = "Fábrica DAO no soportada para el tipo especificado: " + factory;
                throw NoseException.create(new IllegalArgumentException(), userMessage, technicalMessage);
        }
    }
    
    public abstract CityDAO getCityDAO();    
    public abstract CountryDAO getCountryDAO();    
    public abstract DocumentTypeDAO getDocumentTypeDAO();    
    public abstract StateDAO getStateDAO(); 
    public abstract UserDAO getUserDAO(); 
    protected abstract void openConnection();
    
    /**
     * Inicializa la transacción (setAutoCommit(false)).
     * Valida conexión abierta antes de proceder.
     * @throws NoseException si la conexión es inválida o hay error SQLException.
     */
    public final void initializeTransaction() {
        SqlConnectionHelper.validateConnection(connection);
        SqlConnectionHelper.validateIfTransactionNotAlreadyInitiated(connection);  // Reutiliza la validación dedicada
        
        try {
            connection.setAutoCommit(false);
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_TRANSACTION_INIT_FAILED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TRANSACTION_INIT_FAILED.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }
    
    /**
     * Confirma la transacción (commit).
     * Valida conexión abierta y transacción iniciada antes de proceder.
     * @throws NoseException si la conexión es inválida o hay error SQLException.
     */
    public final void commitTransaction() {
        SqlConnectionHelper.validateConnection(connection);
        SqlConnectionHelper.validateIfTransactionWasInitiated(connection);
        
        try {
            connection.commit();
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_TRANSACTION_COMMIT_FAILED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TRANSACTION_COMMIT_FAILED.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }
    
    /**
     * Cancela la transacción (rollback).
     * Valida conexión abierta y transacción iniciada antes de proceder.
     * @throws NoseException si la conexión es inválida o hay error SQLException.
     */
    public final void rollbackTransaction() {
        SqlConnectionHelper.validateConnection(connection);
        SqlConnectionHelper.validateIfTransactionWasInitiated(connection);
        
        try {
            connection.rollback();
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_TRANSACTION_ROLLBACK_FAILED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TRANSACTION_ROLLBACK_FAILED.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }
    
    /**
     * Cierra la conexión.
     * Valida conexión abierta antes de proceder.
     * @throws NoseException si hay error SQLException.
     */
    public final void closeConnection() {
        SqlConnectionHelper.validateConnection(connection);
        
        try {
            connection.close();
        } catch (final SQLException exception) {
            final String userMessage = MessagesEnum.USER_ERROR_CONNECTION_CLOSE_FAILED.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_CONNECTION_CLOSE_FAILED.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }
}