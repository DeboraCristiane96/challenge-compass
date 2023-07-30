package com.css.challenge.Class;

import com.css.challenge.coordinator.Coordinator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "classes")
@AllArgsConstructor
@NoArgsConstructor
public class ClassEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_class")
    private Long id;

    private String name;
    private String dataBegin;
    private String dataEnd;
    private String technology;
    private String partners;
}
