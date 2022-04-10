package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "board")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long code;

    @Column(name = "title", nullable = false, length = 100)
    private String title = "";

    @Column(name = "contents", nullable = false, length = 4000)
    private String contents = "";

    @Column(name = "view", nullable = false)
    private Long view = 0L;

}
