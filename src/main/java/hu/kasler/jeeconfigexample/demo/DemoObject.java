package hu.kasler.jeeconfigexample.demo;

import javax.ejb.Stateless;

@Stateless
public class DemoObject {
	public String sayHello() {
		return "Hello from stateless EJB";
	}
}
