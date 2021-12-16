package service;

import model.User;

public class UserCreator {
    public static final String TEST_DATA_USER_EMAIL = "testdata.user.email";
    public static final String TEST_DATA_USER_PASSWORD = "testdata.user.password";

    public static User withCredentialsFromProperty(){
        return new User(
                TestDataReader.getTestData(TEST_DATA_USER_EMAIL),
                TestDataReader.getTestData(TEST_DATA_USER_PASSWORD)
        );
    }

    public static User withEmptyUsername(){
        return new User("", TestDataReader.getTestData(TEST_DATA_USER_PASSWORD));
    }

    public static User withEmptyPassword(){
        return new User(TestDataReader.getTestData(TEST_DATA_USER_EMAIL), "");
    }
}
