package com.sparta.week04_practice.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @Lob
    private String content;


//    @ManyToOne(fetch = FetchType.LAZY)
//    User 입장에선 Note와 다대일 관계이므로 @ManyToOne이 된다.
//    @JoinColumn(name = "user_id")
//    외래 키 매핑을 위해 JoinColumn을 사용한다.
//    Note 엔티티는 User 엔티티의 id 필드를 "user_id"라는 이름으로 외래 키를 가진다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Note(
            String title,
            String content,
            User user
    ) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public void updateContent(
            String title,
            String content
    ) {
        this.title = title;
        this.content = content;
    }
}
