package com.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(schema = "codenation")
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    @NotNull
    @Size(max = 100)
    private String name;

    @Column(length = 50, nullable = false)
    @NotNull
    @Size(max = 50)
    private String slug;

    @OneToMany
    private Set<Candidate> candidates;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    @NotNull
    private LocalDateTime createdAt;
}
