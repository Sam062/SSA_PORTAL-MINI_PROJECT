package base;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import base.controllers.SSNEnrollmentRestController;
import base.entity.UserEntity;
import base.model.UserModel;
import base.service.SSNService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SSNEnrollmentRestController.class)
public class SSNEnrollmentRestControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private SSNService service;

	@Test
	public void enrollTest() throws Exception {
		UserModel model = new UserModel("SAM","MISHRA","M",new Date(),"UP");
		String json = new ObjectMapper().writeValueAsString(model);

		when(service.saveUser(Mockito.any(UserModel.class))).thenReturn(new UserEntity());

		MockHttpServletRequestBuilder postReq = MockMvcRequestBuilders.post("/saveSsn")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json);

		MvcResult result = mockMvc.perform(postReq).andReturn();

		int status = result.getResponse().getStatus();

		assertEquals(201, status);



	}

}

