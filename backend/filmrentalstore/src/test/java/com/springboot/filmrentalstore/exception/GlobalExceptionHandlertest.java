//package com.springboot.filmrentalstore.exception;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import com.springboot.filmrentalstore.exception.ResourceNotFoundException;
//import com.springboot.filmrentalstore.exception.InvalidInputException;
//import com.springboot.filmrentalstore.exception.UnauthorizedException;import com.springboot.filmrentalstore.service.PaymentService;
//import com.springboot.filmrentalstore.exception.ForbiddenException;
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(GlobalExceptionHandler.class)
//public class GlobalExceptionHandlertest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private YourService yourService; // Mock any service that might throw these exceptions
//
//    // Test case for ResourceNotFoundException
//    @Test
//    void handleResourceNotFoundException() throws Exception {
//        when(yourService.getResourceById(anyLong())).thenThrow(new ResourceNotFoundException("Resource not found"));
//
//        mockMvc.perform(get("/api/resource/1"))  // Assuming this endpoint triggers the exception
//                .andExpect(status().isNotFound())
//                .andExpect(jsonPath("$.message").value("Resource not found"))
//                .andExpect(jsonPath("$.status").value(404));
//    }
//
//    // Test case for InvalidInputException
//    @Test
//    void handleInvalidInputException() throws Exception {
//        mockMvc.perform(get("/api/invalid-input"))  // Assuming this endpoint triggers the exception
//                .andExpect(status().isBadRequest())
//                .andExpect(jsonPath("$.message").value("Invalid input"))
//                .andExpect(jsonPath("$.status").value(400));
//    }
//
//    // Test case for UnauthorizedException
//    @Test
//    void handleUnauthorizedException() throws Exception {
//        mockMvc.perform(get("/api/unauthorized"))  // Assuming this endpoint triggers the exception
//                .andExpect(status().isUnauthorized())
//                .andExpect(jsonPath("$.message").value("Unauthorized"))
//                .andExpect(jsonPath("$.status").value(401));
//    }
//
//    // Test case for ForbiddenException
//    @Test
//    void handleForbiddenException() throws Exception {
//        mockMvc.perform(get("/api/forbidden"))  // Assuming this endpoint triggers the exception
//                .andExpect(status().isForbidden())
//                .andExpect(jsonPath("$.message").value("Forbidden"))
//                .andExpect(jsonPath("$.status").value(403));
//    }
//
//    // Test case for generic Exception (any unexpected error)
//    @Test
//    void handleGenericException() throws Exception {
//        when(PaymentService.getResourceById(anyLong())).thenThrow(new Exception("An error occurred"));
//
//        mockMvc.perform(get("/api/internal-error"))  // Assuming this endpoint triggers a generic exception
//                .andExpect(status().isInternalServerError())
//                .andExpect(jsonPath("$.message").value("An error occurred"))
//                .andExpect(jsonPath("$.status").value(500));
//    }
//}
