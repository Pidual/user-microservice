package com.emazon.usermicroservice.domain.usecase;

import com.emazon.usermicroservice.domain.api.IUserServicePort;
import com.emazon.usermicroservice.domain.exceptions.*;
import com.emazon.usermicroservice.domain.model.User;
import com.emazon.usermicroservice.domain.spi.IUserPersistencePort;

import java.time.LocalDate;
import java.time.Period;

import static com.emazon.usermicroservice.common.Constants.*;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userJpaAdapter;



    public UserUseCase(IUserPersistencePort userJpaAdapter) {
        this.userJpaAdapter = userJpaAdapter;
    }

    @Override
    public User getUserByEmail(String email){
        User user = userJpaAdapter.getUserByEmail(email);
        if(user == null) {
            throw new WrongEmailException(USER_NOT_FOUND_ERROR);
        }
        return user;
    }

    @Override
    public void saveUser(User user) {
        String email = user.getEmail();
        validateUser(user);
        userJpaAdapter.getUserByEmail(email);
        userJpaAdapter.saveUser(user);
    }

    //Validations
    private void validateUser(User user) {
        if (user.getFirstName() == null || user.getFirstName().isEmpty()) {
            throw new UserNameEmptyException(USER_FIRST_NAME_ERROR_MESSAGE);
        }
        if (user.getLastName() == null || user.getLastName().isEmpty()) {
            throw new UserNameEmptyException(USER_SECOND_NAME_ERROR_MESSAGE);
        }
        if (user.getDocumentId() == null || !user.getDocumentId().matches("\\d+")) {
            throw new WrongDocumentIDException(DOCUMENT_ID_ERROR_MESSAGE);
        }
        if (user.getPhoneNumber() == null || !user.getPhoneNumber().matches("^\\+\\d{12}$")) {
            throw new WrongPhoneNumberException(PHONE_NUMBER_ERROR_MESSAGE);
        }
        if (user.getEmail() == null || !user.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new WrongEmailException(WRONG_EMAIL_ERROR_MESSAGE);
        }
        if (user.getBirthDate() == null || !isAdult(user.getBirthDate())) {
            throw new UnderageException(UNDERAGE_ERROR_MESSAGE);
        }
        if(user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new EmptyPasswordException(EMPTY_PASSWORD_ERROR_MESSAGE);
        }

    }

    private boolean isAdult(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears() >= 18;
    }
}
