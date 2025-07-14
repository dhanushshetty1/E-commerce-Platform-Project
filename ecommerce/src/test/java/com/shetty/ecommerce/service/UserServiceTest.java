package com.shetty.ecommerce.service;

import com.shetty.ecommerce.Entities.User;
import com.shetty.ecommerce.dao.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findUser_whenUserExists_returnsUser() {
        // Arrange
        User mockUser = new User();
        mockUser.setEmail("john@example.com");

        when(userRepository.findByEmail("john@example.com")).thenReturn(mockUser);

        // Act
        User foundUser = userService.findUser("john@example.com");

        // Assert
        assertNotNull(foundUser);
        assertEquals("john@example.com", foundUser.getEmail());
        verify(userRepository, times(1)).findByEmail("john@example.com");
    }

    @Test
    void findUser_whenUserDoesNotExist_returnsNull() {
        // Arrange
        when(userRepository.findByEmail("notfound@example.com")).thenReturn(null);

        // Act
        User foundUser = userService.findUser("notfound@example.com");

        // Assert
        assertNull(foundUser);
        verify(userRepository, times(1)).findByEmail("notfound@example.com");
    }
}
