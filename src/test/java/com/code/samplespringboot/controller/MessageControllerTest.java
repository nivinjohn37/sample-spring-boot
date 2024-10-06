package com.code.samplespringboot.controller;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(MessageController.class)
@ActiveProfiles("test") // Specify the profile to use
public class MessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetMessage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/message"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello from Testing Profile!"));
    }
}
