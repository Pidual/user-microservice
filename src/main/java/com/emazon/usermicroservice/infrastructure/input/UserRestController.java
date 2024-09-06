package com.emazon.usermicroservice.infrastructure.input;

import com.emazon.usermicroservice.application.dto.UserDTORequest;
import com.emazon.usermicroservice.application.dto.UserDTOResponse;
import com.emazon.usermicroservice.application.handler.IUserHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Validated
@Tag(name = "User Management", description = "Operations related to user accounts")
public class UserRestController {

    private final IUserHandler userHandler;


    @Operation(summary = "Create a new user", description = "Create a new user with the required details such as name, email, phone number, etc.")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "User created successfully"),
                           @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content)})
    @PostMapping("/")
    public ResponseEntity<String> addUser(@RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Details of the user to be created", required = true, content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserDTORequest.class), examples = @ExampleObject(value = "{\"name\":\"John\", \"lastName\":\"Doe\", \"documentId\":\"123456789\", \"phoneNumber\":\"+573005698325\", \"birthDate\":\"2000-05-15\", \"password\":\"secret\", \"email\":\"john.doe@example.com\"}"))) UserDTORequest userDTORequest) {
        userHandler.saveUser(userDTORequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



    @Operation(summary = "Get user by document ID", description = "Retrieve user details by their document ID")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "User found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserDTORequest.class))),
                           @ApiResponse(responseCode = "404", description = "User not found", content = @Content)})
    @GetMapping("/{documentId}")
    public ResponseEntity<UserDTOResponse> getUserByDocumentId(@PathVariable @Schema(description = "The document ID of the user", example = "123456789") Long documentId) {
        UserDTOResponse response = userHandler.getUser(documentId);
        return ResponseEntity.ok(response); // Return user as a DTO
    }




    @GetMapping("/all")
    public ResponseEntity<List<UserDTOResponse>> getAllUsers() {
        List<UserDTOResponse> users = userHandler.getAllUsers(); // Assuming handler returns List<UserDTOResponse>
        return ResponseEntity.ok(users);
    }
}
