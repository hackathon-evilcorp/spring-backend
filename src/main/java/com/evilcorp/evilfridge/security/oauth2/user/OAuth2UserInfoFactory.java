package com.evilcorp.evilfridge.security.oauth2.user;

import com.evilcorp.evilfridge.exception.OAuth2AuthenticationProcessingException;
import com.evilcorp.evilfridge.util.AuthProvider;

import java.util.Map;

public class OAuth2UserInfoFactory {

  public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
    if(registrationId.equalsIgnoreCase(AuthProvider.google.toString())) {
      return new GoogleOAuth2UserInfo(attributes);
    } else {
      throw new OAuth2AuthenticationProcessingException("Sorry! Login with " + registrationId + " is not supported yet.");
    }
  }
}
