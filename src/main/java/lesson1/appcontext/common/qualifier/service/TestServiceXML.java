package lesson1.appcontext.common.qualifier.service;

import lesson1.appcontext.common.qualifier.api.TestInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(scopeName = "prototype")
//@Lazy
public class TestServiceXML {

    @Autowired
    @Qualifier("beanA")
    private TestInterface testClassA;

    @Autowired
    @Qualifier("testB")
    private TestInterface testClassB;

    public TestInterface getTestClassA() {
        return testClassA;
    }

    public TestInterface getTestClassB() {
        return testClassB;
    }
}
