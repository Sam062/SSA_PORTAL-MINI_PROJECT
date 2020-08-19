package base;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import base.controllers.SSNValidater;

@SpringBootTest
class SsnRegAndValidaterResourceApplicationTests {
	@Autowired
	private SSNValidater validater;
	
	@Test
	void contextLoads() {
		System.out.println("MAIN TEST");
		assertThat(validater).isNotNull();
	}

}
