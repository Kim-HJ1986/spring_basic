package com.spring.week03.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    // JPA의 메서드는 이름에 따라 기능을 바꿀 수 있다. 북마크에 저장된 문서 참조!
    // Memo class가 Timestamped를 상속받고 있기 때문에 ModifiedAt을 사용할 수 있는 것이다.
    // 아래 메서드는 모든 것을 찾되, 수정된 날짜를 역순으로 정렬해서 찾아라는 뜻!
    List<Memo> findAllByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime startDate, LocalDateTime endDate);
}
