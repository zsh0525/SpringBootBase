package com.zsh.www.config.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "swagger")
public class SwaggerYmlConfig {


    private String path;

    private String basePackage;

    private String title;

    private String[] contact3;

    private String version;

    private String description;


    public void setPath(String path) {
        this.path = path;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContact3(String[] contact3) {
        this.contact3 = contact3;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public String getTitle() {
        return title;
    }

    public String[] getContact3() {
        return contact3;
    }

    public String getVersion() {
        return version;
    }

    public String getDescription() {
        return description;
    }
}
