package com.evilcorp.evilfridge.security.oauth2.user;

import java.util.Map;

public abstract class OAuth2UserInfo {
  Map<String, Object> attributes;

  OAuth2UserInfo(Map<String, Object> attributes) {
    this.attributes = attributes;
  }

  public Map<String, Object> getAttributes() {
    return attributes;
  }

  public abstract String getName();

  public abstract String getEmail();

}
