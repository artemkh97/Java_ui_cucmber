package io.demoblaze.utils.config;

import org.aeonbits.owner.ConfigFactory;

public class Project {
    public static ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());

    public static boolean isRemoteWebDriver() {
        System.out.println("config.remoteDriverUrl() " + config.remoteDriverUrl());
        return !config.remoteDriverUrl().equals("");
    }

    public static boolean isVideoOn() {
        return !config.videoStorage().equals("");
    }
}
