package com.gozdesy.mapper;

import com.gozdesy.dto.request.EditProfileRequestDto;
import com.gozdesy.repository.entity.UserProfile;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-12T16:14:59+0300",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class IUserProfileMapperImpl implements IUserProfileMapper {

    @Override
    public UserProfile toUserProfile(EditProfileRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserProfile.UserProfileBuilder userProfile = UserProfile.builder();

        userProfile.username( dto.getUsername() );
        userProfile.firstName( dto.getFirstName() );
        userProfile.lastName( dto.getLastName() );
        userProfile.email( dto.getEmail() );
        userProfile.phone( dto.getPhone() );
        userProfile.photo( dto.getPhoto() );
        userProfile.address( dto.getAddress() );
        userProfile.about( dto.getAbout() );

        return userProfile.build();
    }
}
