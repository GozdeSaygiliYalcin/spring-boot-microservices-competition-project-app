package com.gozdesy.repository;

import com.gozdesy.repository.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAuthRepository extends JpaRepository<Auth, Long> {

    /**
     *yazdığımız metotta kullanıcı adının
     * büyük küçük duyarlı olmaması
     * şifrenin büyük küçük harf duyarlı olmasını ayarlıyoruz
     */

    Optional<Auth> findOptionalByUsernameIgnoreCaseAndPassword(String username, String password);
    @Query("select count(a) > 0 from Auth a where UPPER(a.username) = UPPER(?1) and a.password = ?2")
    Boolean isExist(String username,
                    String password);
}
