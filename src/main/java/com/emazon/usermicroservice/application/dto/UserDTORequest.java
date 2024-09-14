package com.emazon.usermicroservice.application.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import static com.emazon.usermicroservice.common.Constants.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTORequest {

    @NotBlank(message = USER_FIRST_NAME_ERROR_MESSAGE)
    private String firstName;

    @NotBlank(message = USER_SECOND_NAME_ERROR_MESSAGE)
    private String lastName;

    @NotBlank(message = DOCUMENT_ID_ERROR_MESSAGE)
    @Pattern(regexp = "\\d+", message = DOCUMENT_ID_ERROR_MESSAGE)
    private String documentId;

    @NotNull(message = EMPTY_BIRTHDATE_ERROR_MESSAGE)
    @Past(message = UNDERAGE_ERROR_MESSAGE)
    private LocalDate birthDate;

    @NotBlank(message = WRONG_EMAIL_ERROR_MESSAGE)
    @Email(message = WRONG_EMAIL_ERROR_MESSAGE)
    private String email;

    @NotBlank(message = EMPTY_PASSWORD_ERROR_MESSAGE)
    private String password;

    @NotBlank(message = PHONE_NUMBER_ERROR_MESSAGE)
    @Pattern(regexp = "^\\+?\\d{1,13}$", message = PHONE_NUMBER_ERROR_MESSAGE)
    private String phoneNumber;
}
