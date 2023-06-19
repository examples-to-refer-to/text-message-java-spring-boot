package com.convo.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@Table(name="messages")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder(toBuilder = true)
@ToString(callSuper = true)
@Audited
@AuditTable("message-audit")
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode
public class TextMessage {
    @Id
    @GenericGenerator(name="autoId", strategy = "increment")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private LocalDate createdAt;
    private String text;

    private String category;

    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDate updatedAt;
    private String reason;
}
