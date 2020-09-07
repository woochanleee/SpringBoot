package com.woochanleee.boardcrud.service;

import com.woochanleee.boardcrud.domain.entity.BoardEntity;
import com.woochanleee.boardcrud.dto.BoardDto;
import com.woochanleee.boardcrud.domain.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BoardService {
    private BoardRepository boardRepository;

    @Transactional
    public List<BoardDto> getBoardList() {
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDto> boardDtoList= new ArrayList<>();

        for (BoardEntity boardEntity : boardEntities) {
            BoardDto boardDTO = BoardDto.builder()
                    .id(boardEntity.getId())
                    .title(boardEntity.getTitle())
                    .content(boardEntity.getContent())
                    .writer(boardEntity.getWriter())
                    .createdDate(boardEntity.getCreatedDate())
                    .build();

            boardDtoList.add(boardDTO);
        }

        return boardDtoList;
        /*
            Controller와 Service간에 데이터 전달은 dto 객체로 하기 위해, Repository에서 가져온 Entity를 반복문을 통해 dto로 변환하는 작업이 있다.
        */
    }

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