package hu.kasler.jeeconfigexample.config;

import org.apache.deltaspike.core.api.config.PropertyFileConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JeeconfigexamplePropertyFileConfig implements PropertyFileConfig {

	private static final String IKTATO_DEFAULT_CONFIG_STAGE = "dev";
	private static final String IKTATO_CONFIG_PREFIX = "jeeconfigexample-config-";
	private static final String IKTATO_CONFIG_SUFFIX = ".properties";
	private static final String IKTATO_CONFIG_STAGE = "jeeconfigexampleStage";

	private static final Logger LOG = LoggerFactory
			.getLogger(JeeconfigexamplePropertyFileConfig.class);

	@Override
	public String getPropertyFileName() {
		String configStage = null;
		try {
			configStage = System.getenv(IKTATO_CONFIG_STAGE);
			if (configStage == null) {
				configStage = System.getProperty(IKTATO_CONFIG_STAGE);
			}
		} catch (SecurityException | NullPointerException e) {
			LOG.debug("Something wrong happened while trying to resolve env/system config for jeeconfigexample", e);
		}
		if (configStage == null) {
			configStage = IKTATO_DEFAULT_CONFIG_STAGE;
		}
		 String ikatatoConfigPropertyName = new StringBuilder().append(IKTATO_CONFIG_PREFIX)
				.append(configStage).append(IKTATO_CONFIG_SUFFIX)
				.toString();
		 LOG.debug("Jeeconfigexample configuration property file is: {}", ikatatoConfigPropertyName);
		 System.out.println("Jeeconfigexample configuration property file is: " + ikatatoConfigPropertyName);
		 return ikatatoConfigPropertyName;
	}

	@Override
	public boolean isOptional() {
		return false;
	}

}
