package lesson1.appcontext.common.qualifier.service;

import lesson1.appcontext.common.qualifier.api.TestInterface;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("testClassB")
public class TestClassB implements TestInterface {
}
