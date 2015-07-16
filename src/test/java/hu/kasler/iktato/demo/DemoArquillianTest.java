package hu.kasler.jeeconfigexample.demo;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class DemoArquillianTest {

	@EJB
	DemoObject dummyEjb;

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class).addClass(DemoObject.class).addAsManifestResource(EmptyAsset.INSTANCE,
				"beans.xml");
	}

	@Test
	public void testSaysHello() {
		String sayHello = dummyEjb.sayHello();
		System.out.println("Demo ejb says: " + sayHello);
		Assert.assertEquals("Hello from stateless EJB", sayHello);
	}

}
