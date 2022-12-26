package io.demoblaze.utils.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources("classpath:config/config.properties")
public interface ServiceConfig extends Config {
    String env();

    @Key("project_${env}_url")
    String projectUrl();

    @Key("project_api_url")
    String projectApiUrl();
}
