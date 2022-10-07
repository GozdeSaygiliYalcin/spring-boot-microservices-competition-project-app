package com.gozdesy.manager;

import com.gozdesy.dto.request.NewUserCreateDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * microservis yapısında başka bir
 * directory i çağırmak için kullanılır.
 * Ulaşılmak istenen controllerin
 * URL bilgisi parameter olarak verilmelidir.
 * !!Tüm feign işlemlerinde benzersiz isimler verilmelidir!!
 */
@FeignClient(url = "${raceapplication.url.user}v1/api/user", name = "user-service-userprofile", decode404 = true)
public interface IUserManager {

    @PostMapping("/newcreateuser")
    ResponseEntity<Void> NewUserCreate(@RequestBody @Valid NewUserCreateDto dto);

}
