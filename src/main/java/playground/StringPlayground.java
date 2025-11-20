package playground;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class StringPlayground {
    public static void main(String[] args) throws URISyntaxException {
        var validUrl = "https://api.example.dev/auth/callback?post_login_redirect=https%253A%2F%2Fapp.example.dev%2Fcompass%2Fredirect%253FreportToPrefetch%253D4973fcee-5c47-4553-a752-b7a24c10531b%2526returnUrl%253Dhttps%25253A%25252F%25252Fapp.example.dev%25252Fcompass%25252Fdashboard";
        var invalidUrl = "https://example.com?post_login_redirect";

        try {
            System.out.println(extractQueryParam(invalidUrl, "post_login_redirect"));
        } catch (URISyntaxException $exception) {
            System.out.println("post_login_redirect is invalid");
        }

    }

    private static String extractQueryParam(String url, String paramName) throws URISyntaxException {
        var uri = new URI(url);
        var query = uri.getQuery();

        if (query == null) {
            return null;
        }

        for (var param : query.split("&")) {
            var keyAndValue = param.split("=", 2);

            if (keyAndValue.length != 2) {
                continue;
            }

            String key = keyAndValue[0];
            String value = keyAndValue[1];

            if (key.equals(paramName)) {
                return URLDecoder.decode(value, StandardCharsets.UTF_8);
            }
        }

        return null;
    }
}
