/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.finalpoe.LoginsnReg;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;


public class NewEmptyJUnitTest {
    
    public NewEmptyJUnitTest() {
    }
    

    private LoginsnReg loginSystem;
    
    @BeforeEach
    void setUp() {
        loginSystem = new LoginsnReg();

        // Clear any existing user data before each test
        LoginsnReg.userCredentials.clear();
    }
    
    @Test
    void testValidUsername() {
        assertTrue(loginSystem.checkUserName("user_"));
//        assertTrue(loginSystem.checkUserName("a_"));
//         assertFalse(loginSystem.checkUserName("user_name"));
    }

    
    @Test
     void testValidPassword() {
        assertTrue(loginSystem.checkPassword("Password123!"));
//        assertTrue(loginSystem.checkPassword("Password123"));
//         assertTrue(loginSystem.checkPassword("Passw@@1"));
//        assertFalse(loginSystem.checkPassword("ThisPasswordIsTooLongAndShouldFail123!@#"));
    }
    
    @Test
    void testInvalidPasswordNoSpecialChar() {
        assertFalse(loginSystem.checkPassword("Password123"));
        assertFalse(loginSystem.checkPassword("MyPass456"));
    }
    
   
    
    @Test
    void testValidCellphoneNumber() {
        assertTrue(loginSystem.checkCellPhoneNumber("+27123456789"));
        assertFalse(loginSystem.checkCellPhoneNumber("0123456789"));
    }

    @Test
    void testFailedLoginNonExistentUser() {
        assertFalse(loginSystem.loginUser("nonexistent", "Password123!"));
    }
    
   
 
    
    @Test

    void testUsernameEdgeCases() {
        // Empty string
        assertFalse(loginSystem.checkUserName(""));
        
        // Only underscore
        assertTrue(loginSystem.checkUserName("_"));
        
        // Exactly 5 characters with underscore
        assertTrue(loginSystem.checkUserName("test_"));
        
        // 6 characters with underscore (should fail)
        assertFalse(loginSystem.checkUserName("test_1"));
    }
    
    @Test

    void testPasswordEdgeCases() {
        // Exactly 8 characters (minimum)
        assertTrue(loginSystem.checkPassword("Pass123!"));
        
        // Exactly 20 characters (maximum)
        assertTrue(loginSystem.checkPassword("Pass123!Pass123!Pass"));
        
        // 21 characters (should fail)
        assertFalse(loginSystem.checkPassword("Pass123!Pass123!Pass1"));
    }
    @Test
    void validMessageLength(){
        
    }
}
