package playground;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class StringPlayground {
    public static void main(String[] args) throws URISyntaxException {
        var url = "https://example.com/auth/callback?post_login_redirect=https%253A%2F%2Fapp.rqratings.dev%2F&foo=bar";
        System.out.println(extractQueryParam(url, "post_login_redirect"));
    }

    private static String extractQueryParam(String url, String paramName) throws URISyntaxException {
        var uri = new URI(URLDecoder.decode(url, StandardCharsets.UTF_8));
        var query = uri.getQuery();

        for (var param : query.split("&")) {
            var keyAndValue = param.split("=", 2);
            String key = keyAndValue[0];
            String value = keyAndValue[1];

            if (key.equals(paramName)) {
                return value;
            }
        }

        return null;
    }
}
