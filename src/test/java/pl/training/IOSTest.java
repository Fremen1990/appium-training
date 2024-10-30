package pl.training;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pl.training.common.IOSTestConfig;

class IOSTest {

    private final IOSTestConfig config = new IOSTestConfig();

    //@Test
    void test() {
    }

    @BeforeAll
    static void beforeAll() {
        //startServer();
    }

    @AfterAll
    static void afterAll() {
        //stopServer();
    }

    @BeforeEach
    void beforeEach() {
        config.initDriver();
    }

    @AfterEach
    void afterEach() {
        config.releaseDriver();
    }

}
