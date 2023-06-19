package com.convo.services;

import com.convo.models.Status;
import com.convo.models.TextMessage;
import com.convo.models.TextMessageDtoMapper;
import com.convo.models.dto.TextMessageDto;
import com.convo.repositories.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@Transactional
public class TextMessageService {

    private final MessageRepository messageRepository;

    public TextMessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
public TextMessageDto toTextMessageDto(TextMessage textMessage) {
        TextMessageDto textMessageDto = TextMessageDtoMapper.INSTANCE.textMessageToTextMessageoDto(textMessage);
        return textMessageDto;
    }
    public TextMessage saveMessage(TextMessage textMessage) {
        textMessage.setCreatedAt(LocalDate.now());
        textMessage.setUpdatedAt(LocalDate.now());
        textMessage.setStatus(Status.PENDING);
       return  this.messageRepository.save(textMessage);
    }

    public TextMessage editMessage( int id, TextMessage textMessage) {
        TextMessage message = this.messageRepository.findById(id).orElseThrow();
        message.setText(textMessage.getText());
        message.setCategory(textMessage.getCategory());
        message.setUpdatedAt(LocalDate.now());
        return message;
    }

    public List<TextMessage> getAll() {
        return messageRepository.findAll();
    }

    public Integer deleteMessage(Integer id) {
        TextMessage message = this.messageRepository.findById(id).orElseThrow();
        Integer messageId = message.getId();
        this.messageRepository.delete((message));
        return messageId;
    }

    public TextMessage findById(int id) {
        log.debug("Request to get text: {}", id);
       return messageRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Can nnot find this with id"));
    }

    public List<TextMessage> findByStatus(Status status) {
        return messageRepository.findByStatus(status);
    }

    public void approve(Integer id) {
        TextMessage textMessage = findById(id);
    }
}
