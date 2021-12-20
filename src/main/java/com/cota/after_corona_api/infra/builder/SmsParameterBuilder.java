package com.cota.after_corona_api.infra.builder;

import java.util.HashMap;

public class SmsParameterBuilder {
    HashMap<String, String> params;

    public SmsParameterBuilder() {
        params = new HashMap<>();
    }

    public SmsParameterBuilder to(String to) {
        params.put("to", to);
        return this;
    }

    public SmsParameterBuilder from(String from) {
        params.put("from", from);
        return this;
    }

    public SmsParameterBuilder text(String text) {
        params.put("text", text);
        return this;
    }

    public SmsParameterBuilder appVersion(String appVersion) {
        params.put("app_version", appVersion);
        return this;
    }

    public HashMap<String, String> build() {
        params.put("type", "sms");
        return params;
    }
}
