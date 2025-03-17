package kr.co.ch07.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ch07.dto.User1DTO;
import lombok.*;
import org.springframework.stereotype.Repository;

// 엔티티에서 @Setter는 안씀
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity                 // 엔티티 정의 어노테이션
@Table(name="user1")    //메핑 테이블 어노테이션
public class User1 {

    @Id                     //PK 컬럼 설정 어노테이션(생략불가)
    private String uid;

    @Column(name="name")    //메핑 컬럼 설정 어노테이션(속성명과 컬럼명이 동일한 경우 생략가능)
    private String name;

    @Column(name="hp")
    private String hp;


    private int age;

    // DTO 변환 메서드 정의
    public User1DTO toDTO() {

            return User1DTO.builder()
                    .uid(uid)
                    .name(name)
                    .hp(hp)
                    .age(age)
                    .build();
        }


}
