package lesson3;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestProjectDAO.class,
        TestTaskDAO.class,
        TestUserDAO.class
})
public class TestAllClass {
}
