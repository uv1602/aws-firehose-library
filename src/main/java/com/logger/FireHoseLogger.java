package com.logger;

import lombok.Data;

@Data
public class FireHoseLogger {

    private String accessKey;
    private String secretKey;
    private String token;
    private String profile;

    public FireHoseLogger(String profile, String accessKey, String secretKey, String token) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.token = token;
        this.profile = profile;
    }

    public void log(String message) {
        System.out.println("[" + accessKey + ", " + secretKey + ", " + token + ", " + profile + "]: " + message);
    }
}
