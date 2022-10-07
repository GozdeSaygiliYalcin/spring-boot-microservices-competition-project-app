package com.gozdesy.service;

import com.gozdesy.dto.request.EditProfileRequestDto;
import com.gozdesy.dto.request.NewUserCreateDto;
import com.gozdesy.mapper.IUserProfileMapper;
import com.gozdesy.repository.IUserProfileRepository;
import com.gozdesy.repository.entity.UserProfile;
import com.gozdesy.utility.ServiceManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserProfileService extends ServiceManager<UserProfile, Long> {

    private final IUserProfileRepository userProfileRepository;

    public UserProfileService(IUserProfileRepository userProfileRepository) {
        super(userProfileRepository);
        this.userProfileRepository = userProfileRepository;
    }

    public UserProfile createUserProfile(NewUserCreateDto dto) {
        return save(UserProfile.builder()
                .authId(dto.getAuthId())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .build());
    }

    public Boolean updateUserProfile(EditProfileRequestDto dto, Long authId) {
        UserProfile userProfile = IUserProfileMapper.INSTANCE.toUserProfile(dto);
        Optional<UserProfile> optionalUserProfile = userProfileRepository.findOptionalByAuthId(authId);
        if(optionalUserProfile.isEmpty())
            return false;
        try {
            userProfile.setId(optionalUserProfile.get().getId());
            update(userProfile);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//    public List<UserProfile> findAllPage(int currentPage, int pageSize) {
//        Pageable pageable = PageRequest.of(currentPage, pageSize);
//        return userProfileRepository.findAll(pageable);
//    }



    public Page<UserProfile> findAllPage(int currentPage, int pageSize, String sortParameter, String direction){
        Sort sort = Sort.by(Sort.Direction.fromString(direction),sortParameter);
        Pageable pageable = PageRequest.of(currentPage,pageSize,sort);
        return userProfileRepository.findAll(pageable);
    }
}
