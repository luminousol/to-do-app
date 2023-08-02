package com.luminousol.todoapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long toDoId;    // todo 리스트에 부여되는 Id

    @Column(nullable = false, length = 255)
    private String toDoTitle;   // todo 리스트 제목

    @Column(nullable = false)
    private int toDoOrder;  // todo 리스트 우선순위

    private boolean toDoCompleted;  // todo 완료 여부
}
