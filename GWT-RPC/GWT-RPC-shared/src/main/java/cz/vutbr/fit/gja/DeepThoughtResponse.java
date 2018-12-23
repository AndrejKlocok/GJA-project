/*
 * ----------------------------------------------------------------------------
 * GWT RPC example
 *
 * Author:       Tomáš Vlk
 * Date:         2018-12-02
 * File:         DeepThoughtResponse.java
 * Description:  Model class carrying data
 * ----------------------------------------------------------------------------
 */

package cz.vutbr.fit.gja;

import java.io.Serializable;

/**
 * Model class carrying data. Must be serializable.
 */
public class DeepThoughtResponse implements Serializable {

    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
