package com.springboot.filmrentalstore.filter;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockFilterChain;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

class JwtFilterTest {

    @InjectMocks
    private JwtFilter jwtFilter;

    @Mock
    private JwtToken jwtToken;

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private MockFilterChain filterChain;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        filterChain = new MockFilterChain();
    }

    @Test
    void testValidToken() throws Exception {
        String secretKey = "mySecretKey";
        String validToken = Jwts.builder()
                .setSubject("testUser")
                .claim("role", "ROLE_USER")
                .claim("userName", "testUser")
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        when(jwtToken.validate(validToken)).thenReturn(true);
        when(jwtToken.getSecretKey()).thenReturn(secretKey);

        request.addHeader("Authorization", "Bearer " + validToken);

        jwtFilter.doFilterInternal(request, response, filterChain);

      //  assertNotNull(SecurityContextHolder.getContext().getAuthentication());
      //  assertEquals("ROLE_USER", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

    @Test
    void testInvalidToken() throws Exception {
        String invalidToken = "invalidToken";

        when(jwtToken.validate(invalidToken)).thenReturn(false);

        request.addHeader("Authorization", "Bearer " + invalidToken);

        jwtFilter.doFilterInternal(request, response, filterChain);

        assertEquals(401, response.getStatus());
        assertEquals("application/json", response.getContentType());
        assertTrue(response.getContentAsString().contains("Invalid token"));
    }

    @Test
    void testNoToken() throws Exception {
        jwtFilter.doFilterInternal(request, response, filterChain);

        assertEquals(401, response.getStatus());
        assertEquals("application/json", response.getContentType());
        assertTrue(response.getContentAsString().contains("Invalid token"));
    }

    @Test
    void testBypassAuthenticationForAuthEndpoints() throws Exception {
        request.setRequestURI("/api/auth");
        request.setMethod("POST");

        jwtFilter.doFilterInternal(request, response, filterChain);

        assertNull(SecurityContextHolder.getContext().getAuthentication());
    }

    @Test
    void testBypassAuthenticationForUserRegistration() throws Exception {
        request.setRequestURI("/api/user/register");
        request.setMethod("POST");

        jwtFilter.doFilterInternal(request, response, filterChain);

        assertNull(SecurityContextHolder.getContext().getAuthentication());
    }
}
