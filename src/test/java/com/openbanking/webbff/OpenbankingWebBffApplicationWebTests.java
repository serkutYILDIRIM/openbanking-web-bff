package com.openbanking.webbff;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OpenbankingWebBffApplicationWebTests {
	@Test
	void mockMvcBeanIsAvailable() {
		assertNotNull(mockMvc);
	}

	@Test
	void nonExistentEndpointReturnsUnauthorized() throws Exception {
		mockMvc.perform(get("/non-existent-endpoint")).andExpect(status().isUnauthorized());
	}

	@Test
	void rootEndpointDoesNotReturnServerError() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(status().is4xxClientError());
	}

	@Autowired
	private MockMvc mockMvc;
}
