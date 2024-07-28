package com.logger.aws_firehose;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.logger.LoggerInjector;

@SpringBootTest
public class LoggerInjectorTest {

	@Autowired
	private LoggerInjector loggerInjector;

	@Test
	public void testLoggerInjector() {
		assertNotNull(loggerInjector);
		System.out.println("LoggerInjector initialized successfully");
	}
}
