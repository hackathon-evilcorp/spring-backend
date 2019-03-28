package com.evilcorp.evilfridge.security.oauth2.user;

import java.util.Map;

public class GoogleOAuth2UserInfo extends OAuth2UserInfo {

  GoogleOAuth2UserInfo(Map<String, Object> attributes) {
    super(attributes);
  }

  @Override
  public String getName() {
    return (String) attributes.get("name");
  }

  @Override
  public String getEmail() {
    return (String) attributes.get("email");
  }

}
