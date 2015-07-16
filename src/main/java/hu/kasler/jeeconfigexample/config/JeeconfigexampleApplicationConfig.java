package hu.kasler.jeeconfigexample.config;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.deltaspike.core.api.config.ConfigProperty;

@ApplicationScoped
public class JeeconfigexampleApplicationConfig {

	@Inject
	@ConfigProperty(name = "jeeconfigexample.welcomemessage", defaultValue = "welcome default")
	private String jeeconfigexampleMessage;

	public String getJeeconfigexampleMessage() {
		return jeeconfigexampleMessage;
	}
}
