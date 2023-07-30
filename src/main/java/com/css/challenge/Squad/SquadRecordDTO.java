package com.css.challenge.Squad;

import com.css.challenge.student.Student;

import java.util.List;

public record SquadRecordDTO(String name, String instructor, List<Student> students) {
}
