package com.convo.models.dto;

import com.convo.models.Category;
import com.convo.models.Status;
import lombok.*;

import java.time.LocalDate;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class TextMessageDto {
    private int id;
    private LocalDate createdAt;
    private String text;
    private Category category;
    private Status status;
    private LocalDate updatedAt;
}
