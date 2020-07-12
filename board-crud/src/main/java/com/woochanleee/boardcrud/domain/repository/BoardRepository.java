package com.woochanleee.boardcrud.domain.repository;

import com.woochanleee.boardcrud.domain.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
}

/*
    Repository는 인터페이스로 정의하고, JpaRepository 인터페이스를 상속받으면 된다.
        - JpaRepository의 제네릭 타입에는 Entity 클래스와 PK의 타입을 명시해주면 된다.
        - JpaRepository에는 일반적으로 많이 사용하는 데이터 조작을 다루는 함수가 정의되어 있기 때문에, CRUD 작업이 편해진다.

*/