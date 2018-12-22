package com.nediiii.ncu.bbs.repository;

import com.nediiii.ncu.bbs.entity.UserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BbsRepository<UserEntity> {

    @Query(value = "update users set name =:userName where id =:userId", nativeQuery = true)
    @Modifying
    public UserEntity updateName(String userName, int userId);

    @Query(value = "update users set password =:userPassword where id =:userId",nativeQuery = true)
    @Modifying
    public UserEntity updatePassword(String userPassword,int userId);

    @Query(value = "update users set phone =:userPhone where id =:userId",nativeQuery = true)
    @Modifying
    public UserEntity updatePhone(String userPhone,int userId);

    public UserEntity findByName(String name);

    public UserEntity findByNameAndPassword(String name,String password);

}
