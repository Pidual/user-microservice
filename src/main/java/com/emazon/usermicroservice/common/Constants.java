package com.emazon.usermicroservice.common;

public class Constants {

    private Constants() { //this for sonarlint
        throw new IllegalStateException("Utility class");
    }


    public static final Long ROLE_ADMIN = 1L;
    public static final Long ROLE_AUX_BODEGA = 2L;
    public static final Long ROLE_USER = 3L;
    public static final String USER_FIRST_NAME_ERROR_MESSAGE = "El primer no puede estar vacio";
    public static final String USER_SECOND_NAME_ERROR_MESSAGE = "El segundo nombre no puede estar vacio";
    public static final String DOCUMENT_ID_ERROR_MESSAGE = "El documento de identidad debe ser solamente numerico y no puede estar vacio";
    public static final String PHONE_NUMBER_ERROR_MESSAGE = "El numero de telefono debe empezar con + y tener 13 digitos.";

    public static final String WRONG_EMAIL_ERROR_MESSAGE = "El formato del email es incorrecto";
    public static final String UNDERAGE_ERROR_MESSAGE = "El usuario tiene que ser mayor de 18 años";
    public static final String USER_NOT_FOUND_ERROR = "Usuario no encontrado";
    public static final String EMPTY_PASSWORD_ERROR_MESSAGE = "La Contraseña no puede estar vacia";


    public static final String EMPTY_BIRTHDATE_ERROR_MESSAGE ="La fecha de nacimiento no puede estar vacía.";
    public static final String EMPTY_ROL_ERROR_MESSAGE = "El campo de rol no puede estar vacio";
    public static final String ROL_NOT_FOUND_ERROR_MESSAGE = "EL ROL NO FUE ENCONTRADO";



}
