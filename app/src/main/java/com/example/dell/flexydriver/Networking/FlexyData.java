package com.example.dell.flexydriver.Networking;

public class FlexyData {
    private String countryCode;
    private String mobile;
    private String password;
    private String deviceId;
    private String pushToken;
    private String version;
    private String deviceMake;
    private String deviceModel;
    private int deviceType;
    private String deviceTime;
    private int deviceOsVersion;

    public String getCountryCode() {
        return countryCode;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPassword() {
        return password;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getPushToken() {
        return pushToken;
    }

    public String getVersion() {
        return version;
    }

    public String getDeviceMake() {
        return deviceMake;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public int getDeviceType() {
        return deviceType;
    }

    public String getDeviceTime() {
        return deviceTime;
    }

    public int getDeviceOsVersion() {
        return deviceOsVersion;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setPushToken(String pushToken) {
        this.pushToken = pushToken;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setDeviceMake(String deviceMake) {
        this.deviceMake = deviceMake;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public void setDeviceTime(String deviceTime) {
        this.deviceTime = deviceTime;
    }

    public void setDeviceOsVersion(int deviceOsVersion) {
        this.deviceOsVersion = deviceOsVersion;
    }
}
