package com.allo.server.domain.lecture.dto.request;

import com.allo.server.domain.lecture.entity.Lecture;
import com.allo.server.domain.lecture.entity.LectureLanguage;
import com.allo.server.domain.lecture.entity.LectureSubject;
import com.allo.server.domain.lecture.entity.LectureType;
import com.allo.server.domain.user.entity.UserEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LectureSaveRequest (@NotBlank(message = "제목은 필수 입력 값입니다.")
                                    @Size(min=1, max=20, message = "제목은 20이내로 입력해 주세요.")
                                    String title,
                                    @NotNull(message = "lectureLanguage 필수 입력 값입니다.")
                                    LectureLanguage lectureLanguage,
                                    @NotNull(message = "lectureType 필수 입력 값입니다.")
                                    LectureType lectureType,
                                    @NotNull(message = "lectureSubject 필수 입력 값입니다.")
                                    LectureSubject lectureSubject
){

    public static Lecture lectureToEntity(UserEntity userEntity, String fileUrl, int year, int semester, LectureSaveRequest lectureSaveRequest){
        return Lecture.builder()
                .userEntity(userEntity)
                .fileUrl(fileUrl)
                .title(lectureSaveRequest.title)
                .year(year)
                .semester(semester)
                .lectureLanguage(lectureSaveRequest.lectureLanguage)
                .lectureType(lectureSaveRequest.lectureType)
                .lectureSubject(lectureSaveRequest.lectureSubject)
                .build();
    }
}