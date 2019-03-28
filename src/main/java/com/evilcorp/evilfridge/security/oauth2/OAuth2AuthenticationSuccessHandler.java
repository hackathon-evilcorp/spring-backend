package com.evilcorp.evilfridge.security.oauth2;

import com.evilcorp.evilfridge.security.TokenProvider;
import com.evilcorp.evilfridge.util.TokenPayload;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

  private TokenProvider tokenProvider;

  @Autowired
  OAuth2AuthenticationSuccessHandler(TokenProvider tokenProvider) {
    this.tokenProvider = tokenProvider;
  }

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request,
                                      HttpServletResponse response,
                                      Authentication authentication) throws IOException {
    response.getWriter().write(getTokenToResponseBody(authentication));
    getRedirectStrategy().sendRedirect(request, response, determineTargetUrl(request));
    clearAuthenticationAttributes(request);
  }

  private String determineTargetUrl(HttpServletRequest request) {
    return request.getRequestURI();
  }

  private String getTokenToResponseBody(Authentication authentication){
    ObjectMapper mapper = new ObjectMapper();
    try {
      return mapper.writeValueAsString(new TokenPayload(tokenProvider.createToken((authentication))));
    } catch (JsonProcessingException ex) {
      logger.debug("Token conversion failed " + ex);
    }
    return "Token generation failed!";
  }
}
