package com.gozdesy.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NewUserCreateDto {
    /**
     * yeni üyelik oluşturan kişinin
     * auth_id bilgisinin tutulduğu dto burasıdır
     */

    Long authId;
    String username;
    String email;
}
