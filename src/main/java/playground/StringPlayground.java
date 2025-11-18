package playground;

import java.net.URI;
import java.net.URISyntaxException;

public class StringPlayground {
    public static void main(String[] args) throws URISyntaxException {
        var url = "https://example.com/auth/callback?post_login_redirect=https%253A%2F%2Fapp.rqratings.dev%2F&foo=bar";

        var uri = new URI(url);
        var query = uri.getQuery();

        for (var param : query.split("&")) {
            String[] paramKeyAndValue = param.split("=", 2);
            System.out.printf("%s: %s%n", paramKeyAndValue[0], paramKeyAndValue[1]);
        }
    }
}
