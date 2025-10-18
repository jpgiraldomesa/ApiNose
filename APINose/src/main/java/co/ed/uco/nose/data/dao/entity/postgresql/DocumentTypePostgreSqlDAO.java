package co.ed.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.ed.uco.nose.crosscuting.exception.NoseException;
import co.ed.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.ed.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.ed.uco.nose.data.dao.entity.DocumentTypeDAO;
import co.ed.uco.nose.entity.DocumentTypeEntity;

public final class DocumentTypePostgreSqlDAO extends SqlConnectionHelper implements DocumentTypeDAO {

    public DocumentTypePostgreSqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<DocumentTypeEntity> findAll() {
        SqlConnectionHelper.validateConnection(getConnection());

        final List<DocumentTypeEntity> documentTypes = new ArrayList<>();
        final String sql = "SELECT * FROM tipoidentificacion";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    documentTypes.add(mapResultSetToDocumentTypeEntity(resultSet));
                }
            } catch (final SQLException exception) {
                var userMessage = MessagesEnum.USER_ERROR_DOCUMENT_TYPE_FIND_ALL.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DOCUMENT_TYPE_FIND_ALL.getContent() + ": Error ejecutando consulta";
                throw NoseException.create(exception, userMessage, technicalMessage);
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_DOCUMENT_TYPE_FIND_ALL.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DOCUMENT_TYPE_FIND_ALL.getContent() + ": Error preparando consulta";
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_DOCUMENT_TYPE_FIND_ALL_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DOCUMENT_TYPE_FIND_ALL_UNEXPECTED.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }

        return documentTypes;
    }

    @Override
    public List<DocumentTypeEntity> findByFilter(DocumentTypeEntity filterEntity) {
        SqlConnectionHelper.validateConnection(getConnection());

        final List<DocumentTypeEntity> documentTypes = new ArrayList<>();
        final StringBuilder sql = new StringBuilder("SELECT * FROM tipoidentificacion WHERE 1=1");
        final List<Object> params = new ArrayList<>();

        if (filterEntity.getName() != null && !filterEntity.getName().isEmpty()) {
            sql.append(" AND nombre LIKE ?");
            params.add("%" + filterEntity.getName() + "%");
        }

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql.toString())) {
            try {
                for (int i = 0; i < params.size(); i++) {
                    preparedStatement.setObject(i + 1, params.get(i));
                }
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        documentTypes.add(mapResultSetToDocumentTypeEntity(resultSet));
                    }
                } catch (final SQLException exception) {
                    var userMessage = MessagesEnum.USER_ERROR_DOCUMENT_TYPE_FIND_BY_FILTER.getContent();
                    var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DOCUMENT_TYPE_FIND_BY_FILTER.getContent() + ": Error ejecutando consulta";
                    throw NoseException.create(exception, userMessage, technicalMessage);
                }
            } catch (final SQLException exception) {
                var userMessage = MessagesEnum.USER_ERROR_DOCUMENT_TYPE_FIND_BY_FILTER.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DOCUMENT_TYPE_FIND_BY_FILTER.getContent() + ": Error preparando consulta";
                throw NoseException.create(exception, userMessage, technicalMessage);
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_DOCUMENT_TYPE_FIND_BY_FILTER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DOCUMENT_TYPE_FIND_BY_FILTER.getContent() + ": Error en conexión SQL";
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_DOCUMENT_TYPE_FIND_BY_FILTER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DOCUMENT_TYPE_FIND_BY_FILTER_UNEXPECTED.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }

        return documentTypes;
    }

    @Override
    public DocumentTypeEntity findById(UUID id) {
        SqlConnectionHelper.validateConnection(getConnection());

        final String sql = "SELECT * FROM tipoidentificacion WHERE id = ?";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            try {
                preparedStatement.setObject(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return mapResultSetToDocumentTypeEntity(resultSet);
                    }
                    return null;
                } catch (final SQLException exception) {
                    var userMessage = MessagesEnum.USER_ERROR_DOCUMENT_TYPE_FIND_BY_ID.getContent();
                    var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DOCUMENT_TYPE_FIND_BY_ID.getContent() + ": Error ejecutando consulta";
                    throw NoseException.create(exception, userMessage, technicalMessage);
                }
            } catch (final SQLException exception) {
                var userMessage = MessagesEnum.USER_ERROR_DOCUMENT_TYPE_FIND_BY_ID.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DOCUMENT_TYPE_FIND_BY_ID.getContent() + ": Error preparando consulta";
                throw NoseException.create(exception, userMessage, technicalMessage);
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_DOCUMENT_TYPE_FIND_BY_ID.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DOCUMENT_TYPE_FIND_BY_ID.getContent() + ": Error en conexión SQL";
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_DOCUMENT_TYPE_FIND_BY_ID_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DOCUMENT_TYPE_FIND_BY_ID_UNEXPECTED.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    private DocumentTypeEntity mapResultSetToDocumentTypeEntity(ResultSet resultSet) throws SQLException {
        final DocumentTypeEntity entity = new DocumentTypeEntity();

        try {
            entity.setId(UUID.fromString(resultSet.getString("id")));
        } catch (IllegalArgumentException exception) {
            var userMessage = MessagesEnum.USER_ERROR_INVALID_UUID.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_INVALID_UUID.getContent() + ": ID inválido en tipo de identificación";
            throw NoseException.create(exception, userMessage, technicalMessage);
        }

        entity.setName(resultSet.getString("nombre"));

        return entity;
    }
}