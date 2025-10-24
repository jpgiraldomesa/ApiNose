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
import co.ed.uco.nose.data.dao.entity.UserDAO;
import co.ed.uco.nose.entity.CityEntity;
import co.ed.uco.nose.entity.DocumentTypeEntity;
import co.ed.uco.nose.entity.UserEntity;

public final class UserPostgreSqlDAO extends SqlConnectionHelper implements UserDAO {

    public UserPostgreSqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void create(final UserEntity entity) {
        SqlConnectionHelper.ensureConnectionIsNotNull(getConnection());
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO public.usuario (id, tipo_identificacion_id, numero_identificacion, primer_nombre, ");
        sql.append("segundo_nombre, primer_apellido, segundo_apellido, ciudad_residencia_id, correo_electronico, ");
        sql.append("numero_telefono_movil, correo_electronico_confirmado, numero_telefono_movil_confirmado) ");
        sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql.toString())) {
            try {
                setCreateOrUpdateParameters(preparedStatement, entity);
                preparedStatement.executeUpdate();
            } catch (final SQLException exception) {
                var userMessage = MessagesEnum.USER_ERROR_USER_CREATE.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_CREATE.getContent() + ": Error preparando o ejecutando INSERT";
                throw NoseException.create(exception, userMessage, technicalMessage);
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_USER_CREATE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_CREATE.getContent() + ": Error en conexión SQL";
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_USER_CREATE_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_CREATE_UNEXPECTED.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public List<UserEntity> findAll() {
        SqlConnectionHelper.ensureConnectionIsNotNull(getConnection());

        final List<UserEntity> users = new ArrayList<>();
        final String sql = "SELECT * FROM usuario";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    users.add(mapResultSetToUserEntity(resultSet));
                }
            } catch (final SQLException exception) {
                var userMessage = MessagesEnum.USER_ERROR_USER_FIND_ALL.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_FIND_ALL.getContent() + ": Error ejecutando consulta";
                throw NoseException.create(exception, userMessage, technicalMessage);
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_USER_FIND_ALL.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_FIND_ALL.getContent() + ": Error preparando consulta";
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_USER_FIND_ALL_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_FIND_ALL_UNEXPECTED.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }

        return users;
    }

    @Override
    public List<UserEntity> findByFilter(UserEntity filterEntity) {
        SqlConnectionHelper.ensureConnectionIsNotNull(getConnection());

        final List<UserEntity> users = new ArrayList<>();
        final StringBuilder sql = new StringBuilder("SELECT * FROM usuario WHERE 1=1");
        final List<Object> params = new ArrayList<>();

        if (filterEntity.getDocumentNumber() != null && !filterEntity.getDocumentNumber().isEmpty()) {
            sql.append(" AND numero_identificacion = ?");
            params.add(filterEntity.getDocumentNumber());
        }
        if (filterEntity.getDocumentType() != null && filterEntity.getDocumentType().getId() != null) {
            sql.append(" AND tipo_identificacion_id = ?");
            params.add(filterEntity.getDocumentType().getId());
        }
        if (filterEntity.getResidenceCity() != null && filterEntity.getResidenceCity().getId() != null) {
            sql.append(" AND ciudad_residencia_id = ?");
            params.add(filterEntity.getResidenceCity().getId());
        }
        if (filterEntity.getEmail() != null && !filterEntity.getEmail().isEmpty()) {
            sql.append(" AND correo_electronico = ?");
            params.add(filterEntity.getEmail());
        }
        if (filterEntity.isEmailConfirmed()) {
            sql.append(" AND correo_electronico_confirmado = ?");
            params.add(true);
        }
        if (filterEntity.isMobilePhoneNumberConfirmed()) {
            sql.append(" AND numero_telefono_movil_confirmado = ?");
            params.add(true);
        }

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql.toString())) {
            try {
                for (int i = 0; i < params.size(); i++) {
                    preparedStatement.setObject(i + 1, params.get(i));
                }
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        users.add(mapResultSetToUserEntity(resultSet));
                    }
                } catch (final SQLException exception) {
                    var userMessage = MessagesEnum.USER_ERROR_USER_FIND_BY_FILTER.getContent();
                    var technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_FIND_BY_FILTER.getContent() + ": Error ejecutando consulta";
                    throw NoseException.create(exception, userMessage, technicalMessage);
                }
            } catch (final SQLException exception) {
                var userMessage = MessagesEnum.USER_ERROR_USER_FIND_BY_FILTER.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_FIND_BY_FILTER.getContent() + ": Error preparando consulta";
                throw NoseException.create(exception, userMessage, technicalMessage);
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_USER_FIND_BY_FILTER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_FIND_BY_FILTER.getContent() + ": Error en conexión SQL";
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_USER_FIND_BY_FILTER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_FIND_BY_FILTER_UNEXPECTED.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }

        return users;
    }

    @Override
    public UserEntity findById(UUID id) {
        SqlConnectionHelper.ensureConnectionIsNotNull(getConnection());

        final String sql = "SELECT * FROM public.usuario WHERE id = ?";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            try {
                preparedStatement.setObject(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return mapResultSetToUserEntity(resultSet);
                    }
                    return null;
                } catch (final SQLException exception) {
                    var userMessage = MessagesEnum.USER_ERROR_USER_FIND_BY_ID.getContent();
                    var technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_FIND_BY_ID.getContent() + ": Error ejecutando consulta";
                    throw NoseException.create(exception, userMessage, technicalMessage);
                }
            } catch (final SQLException exception) {
                var userMessage = MessagesEnum.USER_ERROR_USER_FIND_BY_ID.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_FIND_BY_ID.getContent() + ": Error preparando consulta";
                throw NoseException.create(exception, userMessage, technicalMessage);
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_USER_FIND_BY_ID.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_FIND_BY_ID.getContent() + ": Error en conexión SQL";
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_USER_FIND_BY_ID_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_FIND_BY_ID_UNEXPECTED.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public void update(UserEntity entity) {
        SqlConnectionHelper.ensureConnectionIsNotNull(getConnection());
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final StringBuilder sql = new StringBuilder();
        sql.append("UPDATE public.usuario SET tipo_identificacion_id = ?, numero_identificacion = ?, primer_nombre = ?, ");
        sql.append("segundo_nombre = ?, primer_apellido = ?, segundo_apellido = ?, ciudad_residencia_id = ?, ");
        sql.append("correo_electronico = ?, numero_telefono_movil = ?, correo_electronico_confirmado = ?, ");
        sql.append("numero_telefono_movil_confirmado = ? WHERE id = ?");

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql.toString())) {
            try {
                setCreateOrUpdateParameters(preparedStatement, entity);
                preparedStatement.setObject(12, entity.getId());
                preparedStatement.executeUpdate();
            } catch (final SQLException exception) {
                var userMessage = MessagesEnum.USER_ERROR_USER_UPDATE.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_UPDATE.getContent() + ": Error preparando o ejecutando UPDATE";
                throw NoseException.create(exception, userMessage, technicalMessage);
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_USER_UPDATE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_UPDATE.getContent() + ": Error en conexión SQL";
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_USER_UPDATE_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_UPDATE_UNEXPECTED.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public void delete(UUID id) {
        SqlConnectionHelper.ensureConnectionIsNotNull(getConnection());
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final String sql = "DELETE FROM public.usuario WHERE id = ?";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            try {
                preparedStatement.setObject(1, id);
                preparedStatement.executeUpdate();
            } catch (final SQLException exception) {
                var userMessage = MessagesEnum.USER_ERROR_USER_DELETE.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_DELETE.getContent() + ": Error preparando o ejecutando DELETE";
                throw NoseException.create(exception, userMessage, technicalMessage);
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_USER_DELETE.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_DELETE.getContent() + ": Error en conexión SQL";
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_USER_DELETE_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_DELETE_UNEXPECTED.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    private void setCreateOrUpdateParameters(PreparedStatement ps, UserEntity entity) throws SQLException {
        ps.setObject(1, entity.getDocumentType().getId());
        ps.setString(2, entity.getDocumentNumber());
        ps.setString(3, entity.getFirstName());
        ps.setString(4, entity.getSecondName());
        ps.setString(5, entity.getFirstSurname());
        ps.setString(6, entity.getSecondSurname());
        ps.setObject(7, entity.getResidenceCity().getId());
        ps.setString(8, entity.getEmail());
        ps.setString(9, entity.getMobilePhoneNumber());
        ps.setBoolean(10, entity.isEmailConfirmed());
        ps.setBoolean(11, entity.isMobilePhoneNumberConfirmed());
    }

    private UserEntity mapResultSetToUserEntity(ResultSet resultSet) throws SQLException {
        final UserEntity entity = new UserEntity();

        try {
            entity.setId(UUID.fromString(resultSet.getString("id")));
        } catch (IllegalArgumentException exception) {
            var userMessage = MessagesEnum.USER_ERROR_USER_INVALID_UUID.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_INVALID_UUID.getContent() + ": ID inválido en usuario";
            throw NoseException.create(exception, userMessage, technicalMessage);
        }

        if (resultSet.getString("tipo_identificacion_id") != null) {
            final DocumentTypeEntity documentType = new DocumentTypeEntity();
            try {
                documentType.setId(UUID.fromString(resultSet.getString("tipo_identificacion_id")));
            } catch (IllegalArgumentException exception) {
                var userMessage = MessagesEnum.USER_ERROR_USER_INVALID_UUID.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_INVALID_UUID.getContent() + ": tipo_identificacion_id inválido";
                throw NoseException.create(exception, userMessage, technicalMessage);
            }
            entity.setDocumentType(documentType);
        }

        entity.setDocumentNumber(resultSet.getString("numero_identificacion"));
        entity.setFirstName(resultSet.getString("primer_nombre"));
        entity.setSecondName(resultSet.getString("segundo_nombre"));
        entity.setFirstSurname(resultSet.getString("primer_apellido"));
        entity.setSecondSurname(resultSet.getString("segundo_apellido"));
        entity.setEmail(resultSet.getString("correo_electronico"));
        entity.setMobilePhoneNumber(resultSet.getString("numero_telefono_movil"));

        if (resultSet.getString("ciudad_residencia_id") != null) {
            final CityEntity residenceCity = new CityEntity();
            try {
                residenceCity.setId(UUID.fromString(resultSet.getString("ciudad_residencia_id")));
            } catch (IllegalArgumentException exception) {
                var userMessage = MessagesEnum.USER_ERROR_USER_INVALID_UUID.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_USER_INVALID_UUID.getContent() + ": ciudad_residencia_id inválido";
                throw NoseException.create(exception, userMessage, technicalMessage);
            }
            entity.setResidenceCity(residenceCity);
        }

        entity.setEmailConfirmed(resultSet.getBoolean("correo_electronico_confirmado"));
        entity.setMobilePhoneNumberConfirmed(resultSet.getBoolean("numero_telefono_movil_confirmado"));

        return entity;
    }
}