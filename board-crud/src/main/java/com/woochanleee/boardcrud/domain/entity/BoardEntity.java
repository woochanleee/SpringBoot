package com.woochanleee.boardcrud.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "board")
public class BoardEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private String writer;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Builder
    public BoardEntity(Long id, String title, String content, String writer) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
    }
}

/*
    @NoArgsConstructor(access = AccessLevel.PROTECTED):
    - 파라미터가 없는 기본 생성자를 추가하는 어노테이션이다. ( JPA 사용을위해 기본 생성자 생성은 필수 )
        - access는 생성자의 접근 권한을 설정하는 속성이며, 최종적으로 protected BoardEntity() { }와 동일하다.
        - protected인 이유는 Entity 생성을 외부에서 할 필요가 없기 때문이다.

    @Getter:
    - 모든 필드에 getter를 자동생성 해주는 어노테이션이다.
    - @Setter 어노테이션은 setter를 자동생성 해주지만, 무분별한 setter 사용은 안정성을 보장받기 어려우므로 Builder 패턴을 사용한다.
        - 참고로 @Getter와 @Setter를 모두 해결해주는 @Data 어노테이션도 있다.

    @Entity:
    - 객체를 테이블과 매핑 할 엔티티라고 JPA에게 알려주는 역할을 하는 어노테이션 이다. ( 엔티티 매핑 )
    - @Entity가 붙은 클래스는 JPA가 관리하며, 이를 엔티티 클래스라 한다.

    @Table(name = "board"):
    - 엔티티 클래스와 매핑되는 테이블 정보를 명시하는 어노테이션이다.
    - name 속성으로 테이블명을 작성할 수 있으며, 생략 시 엔티티 이름이 테이블명으로 자동 매핑된다.

    @Id:
    - 테이블의 기본 키임을 명시하는 어노테이션 이다.
    - 저자는 일반적으로 Id를 대체키로 사용하는 것이 좋다는 관점이라고 생각하고, Long 타입을 사용한다.

    @GeneratedValue(strategy= GenerationType.IDENTITY):
    - 기본키로 대체키를 사용할 때, 기본키 값 생성 전략을 명시한다.

    @Column:
    - 컬럼을 매핑하는 어노테이션이다.

    @Builder:
    - 빌더패턴 클래스를 생성해주는 어노테이션이다
    - @Setter 사용 대신 빌더패턴(?)을 사용해야 안정성을 보장할 수 있다.

    빌더 패턴?
    - 빌더 패턴이란 복합 객체의 생성 과정과 표현 방법을 분리하여 동일한 생성 절차에서 서로 다른 표현 결과를 만들 수 있게 하는 패턴이다.

    Entity 클래스는 테이블과 관련이 있는 것을 알 수 있다.
    비즈니스 로직은 Entity를 기준으로 돌아가기 때문에 Entity를 Request, Response 용도로 사용하는 것은 적절하지 못하다.
    그래서 데이터 전달목적을 갖는 dto 클래스를 정의하여 사용한다.
*/