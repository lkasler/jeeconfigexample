# jeeconfigexample

Sample JEE 7 application to demonstrate custom deltaspike configuration and adjusted arquillian tests using embedded wildfly

Add datasource.cli via jboss.cli command like in the root porojects directory assuming that wildfly 8.2 is already started
**${wildfly_home}\bin\jboss.cli.bat  --file=datasource.cli**

To run arquillian test execute:
**mvn clean package**

The default config file is jeeconfigexample-config-dev.properties  which can be overriden via sytem or env variables. 
with env **jeeconfigexampleStage** or system properties like **-DjeeconfigexampleStage=test**, meaning that **jeeconfigexample-config-test.properties** should be on the classpath.


