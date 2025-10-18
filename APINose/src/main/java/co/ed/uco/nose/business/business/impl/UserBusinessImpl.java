package co.ed.uco.nose.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.ed.uco.nose.business.assembler.entity.impl.UserEntityAssembler;
import co.ed.uco.nose.business.business.UserBusiness;
import co.ed.uco.nose.business.domain.UserDomain;
import co.ed.uco.nose.crosscuting.helper.UUIDHelper;
import co.ed.uco.nose.data.dao.factory.FactoryDAO;

public class UserBusinessImpl implements UserBusiness {

	private FactoryDAO factoryDAO;

	public UserBusinessImpl(final FactoryDAO factoryDAO) {
		this.factoryDAO = factoryDAO;
	}

	@Override
	public void registerNewUserInformation(UserDomain userDomain) {
		var id = UUIDHelper.generateUUID();
		var userEntity = UserEntityAssembler.getUserEntityAssembler().toEntityFromDomain(userDomain);
		factoryDAO.getUserDAO().create(userEntity);

		userEntity.setId(id);

		factoryDAO.getUserDAO().create(userEntity);

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
