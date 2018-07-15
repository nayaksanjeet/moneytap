package com.moneytap.bitcoinwatcher;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BitcoinwatcherApplication.class)
@WebAppConfiguration@AutoConfigureTestDatabase(replace=Replace.NONE)
@PropertySource(value = "classpath:/application.properties")
public class BitcoinwatcherApplicationTests {
	
	
	private static final String AVERAGE_API_URI = "/moneytap/bitcoin/avarage?minutes=4";
	private static final String MEDIAN_API_URI = "/moneytap/bitcoin/median?minutes=4";
	private MockMvc mockMvc;
	@Autowired
    private WebApplicationContext wac;
	@Before
	public void setUp(){
		mockMvc=MockMvcBuilders.webAppContextSetup(wac).build();
	}
	

	@Test
	public void median() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(MEDIAN_API_URI))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
		        
	}
	
	@Test
	public void average() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(AVERAGE_API_URI))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
		        
	}


}
