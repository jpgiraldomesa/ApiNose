package co.ed.uco.nose.business.business.impl;

import java.util.List;

import java.util.UUID;

import co.ed.uco.nose.business.assembler.entity.impl.UserEntityAssembler;
import co.ed.uco.nose.business.business.UserBusiness;
import co.ed.uco.nose.business.domain.UserDomain;
import co.ed.uco.nose.crosscuting.helper.TextHelper;
import co.ed.uco.nose.crosscuting.helper.UUIDHelper;
import co.ed.uco.nose.data.dao.factory.FactoryDAO;

public class UserBusinessImpl implements UserBusiness {

    private FactoryDAO factoryDAO;

    public UserBusinessImpl(final FactoryDAO factoryDAO) {
        this.factoryDAO = factoryDAO;
    }


    @Override
    public void registerNewUserInformation(UserDomain userDomain) {
        // 1. Validar que la información sea consistente
        validateUserInformation(userDomain);

        // 5. Generar identificador único (UUID)
        UUID id = UUIDHelper.generateUUID();

        // 6. Registrar la información
        var userEntity = UserEntityAssembler.getUserEntityAssembler().toEntityFromDomain(userDomain);
        userEntity.setId(id); // Usamos UUID directamente, no String

        factoryDAO.getUserDAO().create(userEntity);
    }

    private void validateUserInformation(UserDomain userDomain) {
        if (userDomain == null) {
            throw new RuntimeException("El dominio de usuario no puede ser nulo.");
        }

        // Validaciones de consistencia basadas en UserEntity
        if (userDomain.getDocumentType() == null) {
            throw new RuntimeException("El tipo de documento no puede ser nulo.");
        }
        if (TextHelper.isNullOrWitespace(userDomain.getDocumentNumber()) || userDomain.getDocumentNumber().length() > 25) {
            throw new RuntimeException("Número de documento inválido (máx 25 caracteres).");
        }
        if (TextHelper.isNullOrWitespace(userDomain.getFirstName()) || userDomain.getFirstName().length() > 20) {
            throw new RuntimeException("Primer nombre inválido (máx 20 caracteres).");
        }
        if (TextHelper.isNullOrWitespace(userDomain.getSecondName()) || userDomain.getSecondName().length() > 20) {
            throw new RuntimeException("Segundo nombre inválido (máx 20 caracteres).");
        }
        if (TextHelper.isNullOrWitespace(userDomain.getFirstSurname()) || userDomain.getFirstSurname().length() > 20) {
            throw new RuntimeException("Primer apellido inválido (máx 20 caracteres).");
        }
        if (TextHelper.isNullOrWitespace(userDomain.getSecondSurname()) || userDomain.getSecondSurname().length() > 20) {
            throw new RuntimeException("Segundo apellido inválido (máx 20 caracteres).");
        }
        if (userDomain.getResidenceCity() == null) {
            throw new RuntimeException("La ciudad de residencia no puede ser nula.");
        }
        if (TextHelper.isNullOrWitespace(userDomain.getEmail()) || userDomain.getEmail().length() > 250) {
            throw new RuntimeException("Email inválido o excede 250 caracteres.");
        }
        if (TextHelper.isNullOrWitespace(userDomain.getMobilePhoneNumber()) || userDomain.getMobilePhoneNumber().length() > 20) {
            throw new RuntimeException("Número de teléfono inválido (máx 20 caracteres).");
        }
    }

    // 1. Validar que la informacion sea consistente a nivel de tipo de dato,
    // longitud , obligatoriedad, formato, rango, reglas propias del objeto.
    // 2. Validar que no exista previamente otro usuario con el mismo tipo de
    // documento y nombre de identificacion.
    // 3. Validar que no exista previamente otro usuario con el mismo correo
    // electronico
    // 4. Validar que no exista previamente otro usuario con el mismo numero de
    // telefono celular
    // 5. Generar un identificador para el nuevo usuario, asegurando que no exista.

    // 6. Registrar la informacin del nuevo usuario.

    @Override
    public void dropUserInformationById(UUID userId) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateUserInformation(UUID id, UserDomain userDomain) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<UserDomain> FindAllUsers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UserDomain> FindUsersByCriteria(UserDomain userFilters) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserDomain findSpecificUserById(UUID userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void confirmMobileNumber(UUID id, int confirmationCode) {
        // TODO Auto-generated method stub

    }

    @Override
    public void confirmEmail(UUID id, int confirmationCode) {
        // TODO Auto-generated method stub

    }

    @Override
    public void sendConfirmationEmail(UUID id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void sendConfirmationMobileNumber(UUID id) {
        // TODO Auto-generated method stub

    }

}
