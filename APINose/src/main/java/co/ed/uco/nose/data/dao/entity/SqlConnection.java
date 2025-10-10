package co.ed.uco.nose.data.dao.entity;

import java.sql.Connection;
import java.sql.SQLException;

import co.ed.uco.nose.crosscuting.exception.NoseException;
import co.ed.uco.nose.crosscuting.helper.ObjectHelper;
import co.ed.uco.nose.crosscuting.messagescatalog.MessagesEnum;

public abstract class SqlConnection {
	
	private Connection connection;
	
	protected SqlConnection(final Connection connection) {
		setConnection(connection);
	}

	protected Connection getConnection() {
		return connection;
	}

	private void setConnection(final Connection connection) {
		if (ObjectHelper.isNull(connection)) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_EMPTY.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		if  (connection.getAutoCommit()) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_TRANSACTION_NOT_STARTED.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_TRANSACTION_NOT_STARTED.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
		try {
			if (connection.isClosed()) {
				var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_CLOSED.getContent();
				var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED.getContent();
				throw NoseException.create(userMessage, technicalMessage);
			}
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
			throw NoseException.create(exception, userMessage, technicalMessage);
		}
		
		
		this.connection = connection;
	}
	
	
}
