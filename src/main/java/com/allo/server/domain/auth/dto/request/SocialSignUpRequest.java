package com.allo.server.domain.auth.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record SocialSignUpRequest(
        @NotBlank(message = "닉네임은 필수 입력 값입니다.")
        @Size(min=2, max=10, message = "닉네임은 2~10자로 입력해 주세요.")
        String nickname,
        Boolean isOptionAgr) {
}
