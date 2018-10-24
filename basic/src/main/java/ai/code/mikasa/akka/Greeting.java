package ai.code.mikasa.akka;

import java.io.Serializable;

public class Greeting implements Serializable {
    public final String message;

    public Greeting(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"message\":\"")
                .append(message).append('\"');

        sb.append('}');
        return sb.toString();
    }
}
