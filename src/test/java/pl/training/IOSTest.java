package pl.training;

import org.junit.jupiter.api.*;
import pl.training.common.IOSTestConfig;

import static pl.training.common.AndroidTestConfig.startServer;
import static pl.training.common.AndroidTestConfig.stopServer;

class IOSTest {

    private final IOSTestConfig config = new IOSTestConfig();

    @Test
    void test() {
    }

    @BeforeAll
    static void beforeAll() {
        startServer();
    }

    @AfterAll
    static void afterAll() {
        stopServer();
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
