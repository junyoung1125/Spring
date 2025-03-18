package kr.co.ch07.entity.board;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"comment", "file"})
@Entity
@Table(name="Board_Article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private String title;
    private String content;

     /*
        @ManyToOne
         - N:1 단방향 관계설정 어노테이션
         - 현재 엔티티인 Article과 User 엔티티를 N:1 관계설정
         - 기본 fetch 전략 Eager를 Lazy로 설정

        @OneToMany
         - 1:N 양방향 관계설정 어노테이션
         - mappedBy 속성은 양방향 관계설정에서 기준이 되는 엔티티의 속성을 설정, FK가 되는 엔터티 속성명을 적용
         - 참조타입은 List

        @JoinColumn
         - User 엔티티가 참조되는 테이블 컬럼명
         - 외래키 참조 컬럼(FK)

        Fetch 전략
         - 엔티티가 조회될때 관계설정된 엔티티가 조회되는 타이밍 전략
         - 1:1, N:1은 즉시로딩(Eager) 전략
         - 성능 문제로 즉시로딩 대신 Lazy 전략 권장


    */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="writer")
    private User user;

    @OneToMany(mappedBy = "article")
    private List<Comment> comment;

    @OneToMany(mappedBy = "article")
    private List<File> file;

    @CreationTimestamp
    private LocalDateTime wdate;
}
