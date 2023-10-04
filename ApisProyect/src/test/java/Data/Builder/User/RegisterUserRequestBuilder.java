package Data.Builder.User;

import Data.Model.User.RegisterUserRequest;


public class RegisterUserRequestBuilder {
    private RegisterUserRequest registerUserRequest;

    private static final String REGISTERED_FIRSTNAME = "Maria";
    private static final String REGISTERED_LASTNAME = "Lopez";
    private static final String REGISTERED_EMAIL = "maria@mail.com";
    private static final String REGISTERED_USER = "maria";
    private static final String REGISTERED_PHONE = "45420582";
    private static final String REGISTERED_PASSWORD= "maria86";

    private static final int USER_STATUS=1;
    private static final int USER_ID=23;



    private RegisterUserRequestBuilder(){
        registerUserRequest = new RegisterUserRequest();
    }

    public static RegisterUserRequestBuilder newUser(){
        return new RegisterUserRequestBuilder();
    }

    public RegisterUserRequestBuilder withFirstName(String firstName){
        this.registerUserRequest.setFirstName(firstName);
        return this;
    }

    public RegisterUserRequestBuilder withLastName(String lastName){
        this.registerUserRequest.setLastName(lastName);
        return this;
    }


    public RegisterUserRequestBuilder withPhone(String phoneNumber){
        this.registerUserRequest.setPhone(phoneNumber);
        return this;
    }

    public RegisterUserRequestBuilder withEmail(String email){
        this.registerUserRequest.setEmail(email);
        return this;
    }

    public RegisterUserRequestBuilder withUsername(String username){
        this.registerUserRequest.setUsername(username);
        return this;
    }

    public RegisterUserRequestBuilder withPassword(String password){
        this.registerUserRequest.setPassword(password);
        return this;
    }

    public RegisterUserRequestBuilder withUserStatus(int userStatus){
        this.registerUserRequest.setUserStatus(userStatus);
        return this;
    }
    public RegisterUserRequestBuilder withId(int id){
        this.registerUserRequest.setId(id);
        return this;
    }

    public RegisterUserRequest build(){
        return registerUserRequest;
    }


    public static RegisterUserRequest newUsers(){
        return newUser()
                .withUsername(REGISTERED_USER)
                .withFirstName(REGISTERED_FIRSTNAME)
                .withLastName(REGISTERED_LASTNAME)
                .withEmail(REGISTERED_EMAIL)
                .withPassword(REGISTERED_PASSWORD)
                .withPhone(REGISTERED_PHONE)
                .withId(USER_ID)
                .withUserStatus(USER_STATUS)
                .build();
    }

}
