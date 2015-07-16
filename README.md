# jeeconfigexample 
**JEE configuration example using deltaspike custom properties file resolver using Wildfly embedded for arquillian tests**

Sample JEE 7 application to demonstrate custom deltaspike properties file configuration and adjusted arquillian tests using embedded Wildfly.

The application skeleton was generated with JBOSS Forge tool.

To run arquillian tests execute:
**mvn clean package**

If you want to deploy and examine the application add first the H2 database connection resource:
Add datasource.cli via jboss.cli command like in the root porojects directory assuming that Wildfly 8.2 is already started
**${wildfly_home}\bin\jboss.cli.bat  --file=datasource.cli**

The default config file is **jeeconfigexample-config-dev.properties**  which can be overriden via sytem or environment variables. 

Using Wildly to deploy the application the url:
**http://localhost:8080/jeeconfigexample/jeeconfigexample**


To customize the properties file name depending on the actual environment set the environment  **jeeconfigexampleStage** (example: export jeeconfigexampleStage=test) or system property variable to the desired value (example: -DjeeconfigexampleStage=test), supposing that **jeeconfigexample-config-{cutomenv}.properties** (example: jeeconfigexample-config-test.properties) is on the classpath.
In the name selection of actual properties file the environment variable has higher precedence order than system property variable following the deltaspike default precedence order fallbacking if both is absent to **dev** (jeeconfigexample-config-dev.properties).

All deltaspike's key order precedence is untouched so precedence order are: environment variables, system properties, properties file.





