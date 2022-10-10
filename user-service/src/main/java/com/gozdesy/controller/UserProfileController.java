package com.gozdesy.controller;


import com.gozdesy.dto.request.EditProfileRequestDto;
import com.gozdesy.dto.request.NewUserCreateDto;
import com.gozdesy.exception.ErrorType;
import com.gozdesy.exception.UserManagerException;
import com.gozdesy.repository.entity.UserProfile;
import com.gozdesy.service.UserProfileService;
import com.gozdesy.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


import java.util.List;
import java.util.Optional;

import static com.gozdesy.constant.ApiUrl.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(BASE_URL+USER)
@Slf4j
public class UserProfileController {

    private final UserProfileService userProfileService;
    private final JwtTokenManager jwtTokenManager;

    @PostMapping(NEW_CREATE_USER)
    public ResponseEntity<Boolean> newUserCreate(@RequestBody @Valid NewUserCreateDto dto) {
        try {
            userProfileService.createUserProfile(dto);
            return ResponseEntity.ok(true);
        } catch (Exception exception) {
            log.info("Tüm kullanıcılar listelendi");
            throw new UserManagerException(ErrorType.USER_DOESNT_CREATED);
        }
    }
    @PostMapping(UPDATE_PROFILE)
    public ResponseEntity<Boolean> updateProfile(@RequestBody @Valid EditProfileRequestDto dto) {

        try {
            Optional<Long> authId = jwtTokenManager.getUserId(dto.getToken());
           if(authId.isEmpty())
               throw new UserManagerException(ErrorType.INVALID_TOKEN);
            return ResponseEntity.ok(userProfileService.updateUserProfile(dto, authId.get()));
        } catch (Exception exception) {
            throw new UserManagerException((ErrorType.INVALID_TOKEN));
        }
    }

    @GetMapping(FINDALL)
    public ResponseEntity<Page<UserProfile>> findAll(int currentPage, int pageSize,  String sortParameter, String direction){
        return ResponseEntity.ok(userProfileService.findAllPage(currentPage,pageSize, sortParameter, direction));
    }

    @GetMapping(FINDALLSLICE)
    public ResponseEntity<Slice<UserProfile>> findAllSlice(int currentPage, int pageSize, String sortParameter, String direction){
        return ResponseEntity.ok(userProfileService.findAllSlice(currentPage,pageSize, sortParameter, direction));
    }
    @GetMapping("/findallcriteria/{page}/{size}/{sortparameter}/{direction}")
    public ResponseEntity<Slice<UserProfile>> findAllCriteria(@PathVariable int page,
                                                              @PathVariable int size,
                                                              @PathVariable String sortparameter,
                                                              @PathVariable String direction) {
        return ResponseEntity.ok(userProfileService.findAllSlice(page, size, sortparameter, direction));
    }

    @GetMapping("/redis")
    @Cacheable(value = "hello_redis")
    public String helloRedis(String message){
        try{
            Thread.sleep(3000);
            return "Message: "+ message;
        }catch (Exception e){
            log.error("Error: "+e.getMessage());
            return "Error";
        }
    }

    @GetMapping("/findAllData")
    public ResponseEntity<List<UserProfile>> findAll(){
        Long start = System.currentTimeMillis();
        System.out.println("Start Time : "+start);
        List<UserProfile> lists = userProfileService.findAll();
        Long end = System.currentTimeMillis();
        System.out.println("End Time : "+end);
        System.out.println("Time UserService....: "+(end-start));
        return ResponseEntity.ok(lists);
    }


    @GetMapping("/getall")
    public List<UserProfile> getAll(){
        log.info("Tüm Kullanıcılar getirildi..........");
        return userProfileService.getAllCache();
    }

    @GetMapping("/clearcache")
    public void clearCache(String key, String parameter){
        userProfileService.clearCache(key, parameter);
    }


}
