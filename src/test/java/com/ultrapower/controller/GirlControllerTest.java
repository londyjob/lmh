package com.ultrapower.controller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {
	
	
//	@Autowired
//	private WebApplicationContext wac;
//	
	@Autowired
	private MockMvc mockMvc;
	
//	@Before
//	public void init() {
//		this.mockMvc= MockMvcBuilders.webAppContextSetup(wac).build();
//	}
	
	@Test
	public void girlList() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/girls"))
		.andExpect(MockMvcResultMatchers.status().isOk());
		//.andExpect(MockMvcResultMatchers.content().string("123"));
	}
}
