package com.woochanleee.boardcrud.service;

import com.woochanleee.boardcrud.dto.BoardDto;
import com.woochanleee.boardcrud.domain.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class BoardService {
    private BoardRepository boardRepository;

    @Transactional
    public Long savePost(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getId();
    }
}

/*
    @AllArgsConstructor:
    - Controller에서 봤던 어노테이션 이다.
    - 마찬가지로 Repository를 주입하기 위해 사용한다.

    @Service:
    - 서비스 계층임을 명시해주는 어노테이션이다.

    @Transactional:
    - 선언적 트랜잭션이라 부르며, 트랜잭션을 적용하는 어노테이션이다.

    save():
    - JpaRepository에 정의된 메서드로, DB에 INSERT, UPDATE를 담당한다.
    - 매개변수로는 Entity를 전달한다.
*/