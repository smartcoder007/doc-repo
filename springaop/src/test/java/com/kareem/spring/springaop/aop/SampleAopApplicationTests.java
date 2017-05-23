

package com.kareem.spring.springaop.aop;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

import com.kareem.spring.aop.SampleAopApplication;

import static org.junit.Assert.assertTrue;


public class SampleAopApplicationTests {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	private String profiles;

	@Before
	public void init() {
		this.profiles = System.getProperty("spring.profiles.active");
	}

	@After
	public void after() {
		if (this.profiles != null) {
			System.setProperty("spring.profiles.active", this.profiles);
		}
		else {
			System.clearProperty("spring.profiles.active");
		}
	}

	@Test
	public void testDefaultSettings() throws Exception {
		SampleAopApplication.main(new String[0]);
		String output = this.outputCapture.toString();
		assertTrue("Wrong output: " + output, output.contains("Hello Kareem"));
	}

	@Test
	public void testCommandLineOverrides() throws Exception {
		SampleAopApplication.main(new String[] { "--name=Kareem" });
		String output = this.outputCapture.toString();
		assertTrue("Wrong output: " + output, output.contains("Hello Kareem"));
	}

}
