package com.convo.repositories;


import com.convo.models.Status;
import com.convo.models.TextMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<TextMessage, Integer>, RevisionRepository<TextMessage, Integer, Long> {

    List<TextMessage> findByStatus(Status status);
}
