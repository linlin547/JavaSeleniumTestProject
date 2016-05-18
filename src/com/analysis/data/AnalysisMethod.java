package com.analysis.data;

import java.util.Map;

/**
 * Created by mac-li on 16/5/17.
 */
public class AnalysisMethod {
    private Map<?, ?> map;

    public AnalysisMethod(Map<String, Object> mapHistory) {
        this.map = mapHistory;
    }

    public Map<String, Object> loginCaseMap() {
        return (Map<String, Object>) map.get("LoginData");
    }

}
