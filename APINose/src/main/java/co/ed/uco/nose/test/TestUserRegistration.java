package co.ed.uco.nose.test;

import co.ed.uco.nose.business.facade.impl.UserFacadeImpl;
import co.ed.uco.nose.crosscuting.exception.NoseException;
import co.ed.uco.nose.crosscuting.helper.UUIDHelper;
import co.ed.uco.nose.dto.CityDTO;
import co.ed.uco.nose.dto.DocumentTypeDTO;
import co.ed.uco.nose.dto.UserDTO;


public class TestUserRegistration {

    public static void main(String[] args) {
        try {
            // Crear un UserDomain con datos de prueba usando UUID
            var userDTO = new UserDTO();

            userDTO.setDocumentType(new DocumentTypeDTO(UUIDHelper.getFromString("550e8400-e29b-41d4-a716-446655440005"))); // Cédula
            userDTO.setDocumentNumber("123456789");
            userDTO.setFirstName("Juan");
            userDTO.setSecondName("Pablo");
            userDTO.setFirstSurname("Giraldo");
            userDTO.setSecondSurname("Mesa");
            userDTO.setResidenceCity(new CityDTO(UUIDHelper.getFromString("592a1855-094f-41b0-aba1-352ed2a8fb8c"))); // Ciudad
            userDTO.setEmail("jpgiraldomesa@example.com");
            userDTO.setMobilePhoneNumber("3101234567");
            userDTO.setEmailConfirmed(false);
            userDTO.setMobilePhoneNumberConfirmed(false);


            var facade = new UserFacadeImpl();

            // Registrar usuario
            facade.registerNewUserInformation(userDTO);

            System.out.println("Gané el semestre: Usuario registrado con éxito.");
        } catch (NoseException e) {
            System.err.println("Mensaje para usuario: " + e.getUserMessage());
            System.err.println("Mensaje técnico: " + e.getTechnicalMessage());
        } catch (Exception e) {
            System.err.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }
}