package com.sujay.TeamService.repo;

import com.sujay.TeamService.model.UserInfo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserInfoRepo {
    public static final String HASH_KEY = "UserInfo";
    @Autowired
    private RedisTemplate template;

    public UserInfo save(UserInfo user) {
        template.opsForHash().put(HASH_KEY, user.getUsername(), user);
        return user;
    }

    public List<UserInfo> getAll() {
        return template.opsForHash().values(HASH_KEY);
    }

    public UserInfo getUserByName(String username) {
        return (UserInfo) template.opsForHash().get(HASH_KEY,username);
    }
}
