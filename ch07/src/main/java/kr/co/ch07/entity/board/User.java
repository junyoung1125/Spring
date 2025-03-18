package kr.co.ch07.entity.board;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name="Board_User")
public class User {
    @Id
    private String uid;
    private String name;
    private String hp;

    @CreationTimestamp  //mysql NOW()
    private LocalDateTime regDate;
}
