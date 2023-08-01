package com.css.challenge.presentation.dto;

import com.css.challenge.model.entity.Student;

import java.util.List;

public record SquadRecordDTO(String name, List<Student> students) {

}
