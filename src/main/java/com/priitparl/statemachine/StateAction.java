package com.priitparl.statemachine;

import com.priitparl.model.URLDataModel;

import java.net.URL;

public interface StateAction {

    State parseURL(URL inputURL, URLDataModel URLDataModelObject) throws Exception;

}
