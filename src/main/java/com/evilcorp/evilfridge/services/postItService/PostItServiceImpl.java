package com.evilcorp.evilfridge.services.postItService;

import com.evilcorp.evilfridge.repositories.PostItRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostItServiceImpl implements PostItService{

  private PostItRepository postItRepository;

  @Autowired
  public PostItServiceImpl(PostItRepository postItRepository) {
    this.postItRepository = postItRepository;
  }
}
