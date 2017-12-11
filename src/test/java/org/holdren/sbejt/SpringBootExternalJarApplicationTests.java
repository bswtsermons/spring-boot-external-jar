package org.holdren.sbejt;

import static org.junit.Assert.assertNotNull;

import org.holdren.sbejt.ExternalJarBean;
import org.holdren.sbejt.InternalClassBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootExternalJarApplicationTests 
{
	// this bean loads just fine!
	@Autowired
	private InternalClassBean internalClassBean;
	
	// this bean will not load!  Even though it is marked with @Component!
	@Autowired(required=false)
	private ExternalJarBean externalJarBean;
	
	@Test
	public void internalBeanAutowired()
	{
		assertNotNull("internal bean was autowired", internalClassBean);
	}
	
	@Test
	public void externalBeanAutowired()
	{
		assertNotNull("external bean was autowireed", externalJarBean);
	}

}
