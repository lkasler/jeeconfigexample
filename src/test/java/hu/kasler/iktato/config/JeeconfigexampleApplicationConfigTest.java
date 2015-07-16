package hu.kasler.jeeconfigexample.config;

import java.io.File;

import javax.inject.Inject;
import javax.swing.plaf.basic.BasicToolBarUI.DockingListener;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.PomEquippedResolveStage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class JeeconfigexampleApplicationConfigTest {

	@Inject
	JeeconfigexampleApplicationConfig jeeconfigexampleConfig;

	@Deployment
	public static WebArchive createDeployment() {
		final PomEquippedResolveStage pom = Maven.resolver().loadPomFromFile("pom.xml");
		
		File[] deltaspikeCore = pom.resolve("org.apache.deltaspike.core:deltaspike-core-impl").withTransitivity().asFile();
		
		return ShrinkWrap.create(WebArchive.class, "testconfig.war")
				.addClass(JeeconfigexamplePropertyFileConfig.class)
				.addPackage(JeeconfigexampleApplicationConfig.class.getPackage())
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsResource("jeeconfigexample-config-dev.properties")
				.addAsLibraries(deltaspikeCore);
	}

	@Test
	public void testSaysHello() {
		String message = jeeconfigexampleConfig.getJeeconfigexampleMessage();
		System.out.println("Jeeconfigexample config says: " + message);
		Assert.assertEquals("Welcome in the jeeconfigexample universe!", message);
	}

}
