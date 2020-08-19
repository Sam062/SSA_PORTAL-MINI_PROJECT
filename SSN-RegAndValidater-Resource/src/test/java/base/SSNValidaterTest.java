package base;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import base.controllers.SSNValidater;
import base.service.SSNService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SSNValidater.class)
public class SSNValidaterTest {
	
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private SSNService service;
	
	@Test
	public void TestSSNValildater() throws Exception {
		 when(service.findBySSN("12345")).thenReturn(true);
		
		MockHttpServletRequestBuilder getReq = MockMvcRequestBuilders.get("/validateSSN/12345");
		MvcResult result = mockMvc.perform(getReq).andReturn();
		
		MockHttpServletResponse resp= result.getResponse();
		int status = resp.getStatus();
		System.out.println(resp.getContentAsString());
		
		assertEquals(200, status);
	}

}
