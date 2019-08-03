package lesson1.appcontext.common.qualifier.service;

import lesson1.appcontext.common.qualifier.api.TestInterface;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("testClassA")
//@Scope("prototype")
//@Primary
public class TestClassA implements TestInterface {
}
