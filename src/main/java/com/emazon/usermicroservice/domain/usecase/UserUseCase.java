package com.emazon.usermicroservice.domain.usecase;

import com.emazon.usermicroservice.domain.api.IUserServicePort;
import com.emazon.usermicroservice.domain.exceptions.WrongEmailException;
import com.emazon.usermicroservice.domain.model.User;
import com.emazon.usermicroservice.domain.spi.IUserPersistencePort;

import java.time.LocalDate;
import java.time.Period;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userJpaAdapter;

    private static final  String NOT_FOUND_ERROR = "DIDNT FOUND WHATEVER YOU WANTED XD";

    public UserUseCase(IUserPersistencePort userJpaAdapter) {
        this.userJpaAdapter = userJpaAdapter;
    }

    @Override
    public User getUserByEmail(String email){
        User user = userJpaAdapter.getUserByEmail(email);

        if(user == null) {
            throw new WrongEmailException(NOT_FOUND_ERROR);
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
            throw new IllegalArgumentException("First name is required.");
        }
        if (user.getLastName() == null || user.getLastName().isEmpty()) {
            throw new IllegalArgumentException("Last name is required.");
        }
        if (user.getDocumentId() == null || !user.getDocumentId().matches("\\d+")) {
            throw new IllegalArgumentException("Document ID must be numeric.");
        }
        if (user.getPhoneNumber() == null || !user.getPhoneNumber().matches("^\\+\\d{12}$")) {
            throw new IllegalArgumentException("Phone number must start with + and have up to 13 digits.");
        }
        if (user.getEmail() == null || !user.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        if (user.getBirthDate() == null || !isAdult(user.getBirthDate())) {
            throw new IllegalArgumentException("User must be an adult.");
        }
        // The password should already be encrypted before being stored.
    }

    private boolean isAdult(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears() >= 18;
    }
}
