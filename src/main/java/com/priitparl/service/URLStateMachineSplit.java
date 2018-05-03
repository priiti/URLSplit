package com.priitparl.service;

import com.priitparl.model.URLDataModel;
import com.priitparl.statemachine.State;

import java.net.URL;

/**
 * State machine implementation for splitting input URL.
 */

public class URLStateMachineSplit implements URLSplitter {

    public URLStateMachineSplit() {}

    /**
     * Splits URL into different parts according to state machine.
     * Initial state is set to State.INITIAL.
     * Then while loop is used to set the values for URLDataModel model. With every loop,
     * new state will be returned from Java Enum based state machine.
     * When State.END is reached, URLDataModel model object will be returned.
     * @param inputURL Given URL String which will be used in State Machine
     * @return URL object with values given using state machine implementation
     * @throws Exception
     */
    @Override
    public URLDataModel splitURL(String inputURL) throws Exception {

        URLDataModel stateMachineURLDataModel = new URLDataModel();

        try {

            State stateMachine = State.INITIAL;
            URL givenURL = new URL(inputURL);

            while (!stateMachine.equals(State.END)) {
                stateMachine = stateMachine.parseURL(givenURL, stateMachineURLDataModel);
            }

        } catch (Exception e) {
            throw new Exception(String.format("Could not split given URL. %s", e.getMessage()));
        }

        return stateMachineURLDataModel;
    }
}
