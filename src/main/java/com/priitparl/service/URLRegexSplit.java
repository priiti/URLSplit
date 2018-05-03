package com.priitparl.service;

import com.priitparl.model.URLDataModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLRegexSplit implements URLSplitter {
    /**
     * RFC 3986 Parsing a URI Reference with a Regular Expression
     * ^(([^:/?#]+):)?(//([^/?#]*))?([^?#]*)(\?([^#]*))?(#(.*))?
     *  12            3  4          5       6  7        8 9
     *
     *  http://www.ics.uci.edu/pub/ietf/uri/#Related
     *  $1 = http:
     *  $2 = http
     *  $3 = //www.ics.uci.edu
     *  $4 = www.ics.uci.edu
     *  $5 = /pub/ietf/uri/
     *  $6 = <undefined>
     *  $7 = <undefined>
     *  $8 = #Related
     *  $9 = Related
     *
     */
    private static final String REGEX_PATTERN = "^(([^:/?#]+):)?(//([^/?#]*))?([^?#]*)(\\?([^#]*))?(#(.*))?";
    private Pattern urlRegexPattern;

    /**
     * Initialize regex pattern for matcher usage
     */
    public URLRegexSplit() {
        urlRegexPattern = Pattern.compile(REGEX_PATTERN);
    }

    /**
     * Splits URL into different parts according to given RegEx pattern.
     * Matcher uses previously initialized RegEx pattern to match given input against pattern.
     * Matcher then finds sub sequence of the input sequence that matches the pattern.
     * We can get values from the matcher via desired groups which matcher provides from given input and pattern.
     * It also has logic for specified optional values and then builds URLDataModel object.
     * @param inputURL Given URL String which will be matched against RegEx pattern.
     * @return URL object with values from matched URL and RegEx pattern.
     * @throws Exception
     */
    @Override
    public URLDataModel splitURL(String inputURL) throws Exception {
        URLDataModel regexURLDataModel;

        try {
            Matcher urlMatcher = urlRegexPattern.matcher(inputURL);
            urlMatcher.find();

            String scheme = urlMatcher.group(2);
            String hostAndPort = urlMatcher.group(4);
            String host;
            String port = null;

            if (hostAndPort.contains(":")) {
                host = hostAndPort.split(":")[0];
                port = hostAndPort.split(":")[1];
            } else
                host = hostAndPort;

            String path = urlMatcher.group(5);
            String params = urlMatcher.group(7);

            regexURLDataModel = new URLDataModel(scheme, host, port, path, params);

        } catch (Exception e) {
            throw new Exception(String.format("Could not split given URL. %s", e.getMessage()));
        }

        return regexURLDataModel;
    }
}
