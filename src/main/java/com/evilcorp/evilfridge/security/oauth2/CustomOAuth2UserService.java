package com.evilcorp.evilfridge.security.oauth2;

import com.evilcorp.evilfridge.exception.OAuth2AuthenticationProcessingException;
import com.evilcorp.evilfridge.exception.ResourceNotFoundException;
import com.evilcorp.evilfridge.models.UserModel;
import com.evilcorp.evilfridge.repositories.UserModelRepository;
import com.evilcorp.evilfridge.security.UserPrincipal;
import com.evilcorp.evilfridge.security.oauth2.user.OAuth2UserInfo;
import com.evilcorp.evilfridge.security.oauth2.user.OAuth2UserInfoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService implements UserDetailsService {

  private UserModelRepository userRepository;

  @Autowired
  public CustomOAuth2UserService(UserModelRepository userRepository){
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String email)
      throws UsernameNotFoundException {
    UserModel user = userRepository.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException("User not found with email : " + email));
    return UserPrincipal.create(user);
  }

  public UserDetails loadUserById(Long id) {
    UserModel user = userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    return UserPrincipal.create(user);
  }

  @Override
  public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
    OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);

    try {
      return processOAuth2User(oAuth2UserRequest, oAuth2User);
    } catch (AuthenticationException ex) {
      throw ex;
    } catch (Exception ex) {
      throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
    }
  }

  private OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
    OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(
        oAuth2UserRequest.getClientRegistration().getRegistrationId(),
        oAuth2User.getAttributes());
    if(StringUtils.isEmpty(oAuth2UserInfo.getEmail())) {
      throw new OAuth2AuthenticationProcessingException("Email not found from OAuth2 provider");
    }

    Optional<UserModel> optionalUser = userRepository.findByEmail(oAuth2UserInfo.getEmail());
    UserModel user;
    user = optionalUser.orElse(registerNewUser(oAuth2UserInfo));
    return UserPrincipal.create(user, oAuth2User.getAttributes());
  }

  private UserModel registerNewUser(OAuth2UserInfo oAuth2UserInfo) {
    UserModel user = new UserModel();
    user.setName(oAuth2UserInfo.getName());
    user.setEmail(oAuth2UserInfo.getEmail());
    return userRepository.save(user);
  }

}
