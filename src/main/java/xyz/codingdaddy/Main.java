package xyz.codingdaddy;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import xyz.codingdaddy.domain.User;

import javax.transaction.Transactional;

@QuarkusMain
public class Main implements QuarkusApplication {

    public static void main(String... args) {
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args) {
        addTestUser("user");
        addTestUser("admin");

        Quarkus.waitForExit();

        return 0;
    }

    @Transactional
    public void addTestUser(String username) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(username);
        user.setEmail(username.concat("@example.org"));

        user.persistAndFlush();
    }
}