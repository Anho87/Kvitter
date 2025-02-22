package com.example.kvitter.UserTests;

import com.example.kvitter.entities.Kvitter;
import com.example.kvitter.entities.User;
import com.example.kvitter.repos.UserRepo;
import com.example.kvitter.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserIntegrationTests {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    private UUID userId = UUID.randomUUID();
    private String userEmail = "mario.bros@nintendo.com";
    private String userPassword = "itsame123";
    private String userName = "Mario";
    private List<Kvitter> kvitterList = new ArrayList<>();
    @BeforeEach
    void setUp() {
        userRepo.deleteAll();
        User user = new User(userEmail, userPassword, userName, kvitterList);
        userRepo.save(user);
    }


    @Test
    void testFindUserByEmail() {
        User user = userRepo.findByEmail(userEmail);
        assertNotNull(user);
        assertEquals(userEmail, user.getEmail());
    }


}
