package com.priitparl.model;

/**
 * Model for URL
 * Variables: Scheme, host, port, path, params
 */

public class URLDataModel {

    private String scheme;
    private String host;
    private String port;
    private String path;
    private String params;

    public URLDataModel() {}

    public URLDataModel(String scheme, String host, String port, String path, String params) {
        this.scheme = scheme;
        this.host = host;
        this.port = port;
        this.path = path;
        this.params = params;
    }

    public String getScheme() {
        return scheme;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getPath() {
        return path;
    }

    public String getParams() {
        return params;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setParams(String params) {
        this.params = params;
    }

    @Override
    public String toString() {
        String newLine = "\n";
        StringBuilder URLStringBuilder = new StringBuilder();

        URLStringBuilder.append(getScheme());
        URLStringBuilder.append(newLine);
        URLStringBuilder.append(getHost());
        if (getPort() != null) {
            URLStringBuilder.append(newLine);
            URLStringBuilder.append(getPort());
        }
        URLStringBuilder.append(newLine);
        URLStringBuilder.append(getPath());
        if (getParams() != null) {
            URLStringBuilder.append(newLine);
            URLStringBuilder.append(getParams());
        }

        return URLStringBuilder.toString();
    }
}
