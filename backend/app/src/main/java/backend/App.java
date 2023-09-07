package backend;

import io.javalin.Javalin;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        Javalin app = Javalin.create()
                .get("/", ctx -> ctx.result("Hello World"))
                .start(8080);
    }
}
