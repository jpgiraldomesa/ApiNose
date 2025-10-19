package co.ed.uco.nose.business.facade.impl;

import java.util.List;
import java.util.UUID;

import co.ed.uco.nose.business.assembler.dto.impl.UserDTOAssembler;
import co.ed.uco.nose.business.business.impl.UserBusinessImpl;
import co.ed.uco.nose.business.facade.UserFacade;
import co.ed.uco.nose.crosscuting.exception.NoseException;
import co.ed.uco.nose.data.dao.factory.FactoryDAO;
import co.ed.uco.nose.dto.UserDTO;

public final class UserFacadeImpl implements UserFacade {
	
	@Override
	public void registrarNewUserInformation(UserDTO userDTO) {
		var factoryDAO = FactoryDAO.getFactory();
		var business = new UserBusinessImpl(factoryDAO);
		
		
		try {
			factoryDAO.initializeTransaction();
			
			var userDomain = UserDTOAssembler.getUserDTOAssembler().toDomainFromDTO(userDTO);
			business.registerNewUserInformation(userDomain);
			factoryDAO.commitTransaction();
			
			
		} catch (final NoseException exception) {
			factoryDAO.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			factoryDAO.rollbackTransaction();
			var userMessage = "Se ha presentado un problema inesperado al registrar la información del nuevo usuario. Por favor intente nuevamente y si el problema persiste contacte al administrador del sistema.";
			var technicalMessage = "Se ha presentado un problema inesperado al registrar la información del nuevo usuario. Por favor revise el log de errores para mayor detalle del problema.";
			//Implementar en el MessagesEnum
			throw NoseException.create(exception, userMessage, technicalMessage);
		}finally {
			factoryDAO.closeConnection();
		}
	}

	@Override
	public void dropUserInformationById(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserInformation(UUID id, UserDTO userDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserDTO> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> findUsersByFilter(UserDTO userFilters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO findSpecificUser(UUID id) {
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
