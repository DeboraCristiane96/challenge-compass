package com.css.challenge.common;

import com.css.challenge.model.entity.Instructor;

public class InstructorConstants {
    public static Instructor INSTRUCTOR = new Instructor("Victor","victor@gmail.com","victor@compass.com.br","111-123-345-11",true,"12/12/1998",
            "solteiro",'M',"(87)9990-7709","Recife",123,"Recife","João","Mariana","css" );
    public static Instructor INVALID_INSTRUCTOR = new Instructor("","","","","","",' ',"","","","","");
}
