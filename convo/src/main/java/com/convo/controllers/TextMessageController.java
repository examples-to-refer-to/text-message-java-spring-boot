package com.convo.controllers;

import com.convo.models.Status;
import com.convo.models.TextMessage;
import com.convo.services.TextMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/texts")
@Slf4j
public class TextMessageController {


    private final TextMessageService textMessageService;

    public TextMessageController(TextMessageService textMessageService) {
        this.textMessageService = textMessageService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TextMessage>> getAll() {
        return ResponseEntity.ok(textMessageService.getAll());
    }


    @GetMapping
    public ResponseEntity<List<TextMessage>> getMessageByStatus(@RequestParam Status status) {
        return ResponseEntity.ok(textMessageService.findByStatus(status));
    }

    @PostMapping
    public ResponseEntity<TextMessage> save( @RequestBody TextMessage textMessage) {
        log.debug("REST to create message: {} ", textMessage);
        return ResponseEntity.ok(textMessageService.saveMessage(textMessage));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TextMessage> editTextMessage(@PathVariable(name="id") Integer id, @RequestBody TextMessage textMessage) {
        return ResponseEntity.ok(textMessageService.editMessage(id, textMessage));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") int id) {
        log.debug("REST to delete text, textId: {}", id);
        return ResponseEntity.ok(textMessageService.deleteMessage(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TextMessage> getById(@PathVariable("id") int id) {
        return ResponseEntity.ok(textMessageService.findById(id));
    }

}
