package pl.training;

import org.junit.jupiter.api.*;
import pl.training.common.IOSTestConfig;

class IOSTest {

    private final IOSTestConfig config = new IOSTestConfig();

    @Test
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
