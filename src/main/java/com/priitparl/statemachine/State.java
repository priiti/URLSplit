package com.priitparl.statemachine;

import com.priitparl.model.URLDataModel;

import java.net.URL;

/**
 * State machine implementation using Java Enums.
 * State machine has 7 states: INITIAL, SCHEME, HOST, PORT, PATH, PARAMS, END.
 * State also implements StateAction interface, which has parseURL method.
 * parseURL method takes java.net.URL object and URLDataModel model object.
 * Values are set to URLDataModel model through setters and new state is then returned.
 * It runs until desired final state is fulfilled and finishes, meanwhile building up URLDataModel model object.
 */

public enum State implements StateAction {

    INITIAL {
        @Override
        public State parseURL(URL inputURL, URLDataModel URLDataModelObject) throws Exception {
            return SCHEME;
        }
    },
    SCHEME {
        @Override
        public State parseURL(URL inputURL, URLDataModel URLDataModelObject) throws Exception {
            URLDataModelObject.setScheme(inputURL.getProtocol());
            return HOST;
        }

    },
    HOST {
        @Override
        public State parseURL(URL inputURL, URLDataModel URLDataModelObject) throws Exception {
            URLDataModelObject.setHost(inputURL.getHost());
            return PORT;
        }
    },
    PORT {
        @Override
        public State parseURL(URL inputURL, URLDataModel URLDataModelObject) throws Exception {
            URLDataModelObject.setPort(inputURL.getPort() != -1 ? String.valueOf(inputURL.getPort()) : null);
            return PATH;
        }
    },
    PATH {
        @Override
        public State parseURL(URL inputURL, URLDataModel URLDataModelObject) throws Exception {
            URLDataModelObject.setPath(inputURL.getPath());
            return PARAMS;
        }
    },
    PARAMS {
        @Override
        public State parseURL(URL inputURL, URLDataModel URLDataModelObject) throws Exception {
            URLDataModelObject.setParams(inputURL.getQuery() != null ? inputURL.getQuery() : null);
            return END;
        }
    },
    END {
        @Override
        public State parseURL(URL inputURL, URLDataModel URLDataModelObject) throws Exception {
            return this;
        }
    }
}

