package co.ed.uco.nose.business.facade;

import java.util.List;
import java.util.UUID;

import co.ed.uco.nose.dto.UserDTO;

public interface UserFacade {
	
	void registerNewUserInformation(UserDTO userDTO);
	
	void dropUserInformationById(UUID id);
	
	void updateUserInformation(UUID id, UserDTO userDTO);
	
	List<UserDTO> findAllUsers();
	
	List<UserDTO> findUsersByFilter (UserDTO userFilters);
	
	UserDTO findSpecificUser (UUID id);
	
	void confirmMobileNumber(UUID id, int confirmationCode);
	
	void confirmEmail(UUID id, int confirmationCode);
	
	void sendConfirmationEmail(UUID id);
	
	void sendConfirmationMobileNumber(UUID id);

}
