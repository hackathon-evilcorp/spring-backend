package com.evilcorp.evilfridge.services.postItService;

import com.evilcorp.evilfridge.models.PostIt;
import com.evilcorp.evilfridge.repositories.PostItRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostItServiceImpl implements PostItService{

  private PostItRepository postItRepository;

  @Autowired
  public PostItServiceImpl(PostItRepository postItRepository) {
    this.postItRepository = postItRepository;
  }

  @Override
  public List<PostIt> getPostItsOfUser(Long userId) {
    return null;
  }

  @Override
  public List<PostIt> getPostItsOfFridge(Long fridgeId) {
    return null;
  }

  @Override
  public List<PostIt> getPostItsOfUserAndFridge(Long userId, Long fridgeId) {
    return null;
  }

  @Override
  public boolean savePostIt(PostIt postIt) {
    return false;
  }

  @Override
  public boolean deletePostIt(Long postItId) {
    return false;
  }
}
