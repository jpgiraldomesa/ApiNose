package co.ed.uco.nose.business.business;

import java.util.List;
import java.util.UUID;

import co.ed.uco.nose.business.domain.UserDomain;

public interface UserBusiness {

	void registerNewUserInformation(UserDomain userDomain);
	
	void dropUserInformationById(UUID userId);
	
	void updateUserInformation(UUID id, UserDomain userDomain);
	
	List<UserDomain> FindAllUsers();
	
	List<UserDomain> FindUsersByCriteria(UserDomain userFilters);
	
	UserDomain findSpecificUserById(UUID userId);
	
	void confirmMobileNumber(UUID id, int confirmationCode);
	
	void confirmEmail(UUID id, int confirmationCode);
	
	void sendConfirmationEmail(UUID id);
	
	void sendConfirmationMobileNumber(UUID id);
}
