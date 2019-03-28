package com.evilcorp.evilfridge.services.postItService;

import com.evilcorp.evilfridge.models.PostIt;

import java.util.List;

public interface PostItService {
    public List<PostIt> getPostItsOfUser(Long userId);
    public List<PostIt> getPostItsOfFridge(Long fridgeId);
    public List<PostIt> getPostItsOfUserAndFridge(Long userId, Long fridgeId);
    public boolean savePostIt(PostIt postIt);
    public boolean deletePostIt(Long postItId);
}
