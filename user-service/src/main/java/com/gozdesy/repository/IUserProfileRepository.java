package com.gozdesy.repository;

import com.gozdesy.repository.entity.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserProfileRepository extends MongoRepository<UserProfile, Long> {

    @Query("select COUNT(a)>0 from UserProfile a where  a.authId = ?1")
    Boolean isExists(Long authId);

    Optional<UserProfile> findOptionalByAuthId(Long authId);
}
