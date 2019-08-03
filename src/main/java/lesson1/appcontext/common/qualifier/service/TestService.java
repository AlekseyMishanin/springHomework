package lesson1.appcontext.common.qualifier.service;

import lesson1.appcontext.common.qualifier.api.TestInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    @Qualifier("testClassA")
    private TestInterface testClassA;

    @Autowired
    @Qualifier("testClassB")
    private TestInterface testClassB;

    public TestInterface getTestClassA() {
        return testClassA;
    }

    public TestInterface getTestClassB() {
        return testClassB;
    }
}
