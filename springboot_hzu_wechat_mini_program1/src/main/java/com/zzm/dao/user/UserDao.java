package com.zzm.dao.user;

import com.zzm.dao.UserWithoutOpenidProjection;
import com.zzm.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface UserDao extends JpaRepository<User, Long> {
    User findByOpenid(String openid);
    boolean existsByOpenid(String openid);

    // 添加这个自定义查询方法
    @Query("SELECT u.id FROM User u WHERE u.openid = ?1")
    Long findIdByOpenid(String openid);
    @Query("SELECT u.id AS id, u.nickname AS nickname, u.avatarUrl AS avatarUrl, u.gender AS gender FROM User u WHERE u.openid = ?1")
    UserWithoutOpenidProjection findByOpenid1(String openid);
    @Query("SELECT u.id AS id, u.nickname AS nickname, u.avatarUrl AS avatarUrl, u.gender AS gender FROM User u WHERE u.id = ?1")
    UserWithoutOpenidProjection findById1(Long id);

    List<User> findByNicknameContaining(String nickname);

}
