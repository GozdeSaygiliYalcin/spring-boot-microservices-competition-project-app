package com.gozdesy.mapper;

import com.gozdesy.dto.request.EditProfileRequestDto;
import com.gozdesy.repository.entity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IUserProfileMapper {
    IUserProfileMapper INSTANCE = Mappers.getMapper(IUserProfileMapper.class);

    //final anahtar kelimesi null gelme problemi için yazıldı
    UserProfile toUserProfile(final EditProfileRequestDto dto);

}
