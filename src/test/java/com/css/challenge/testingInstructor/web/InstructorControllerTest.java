package com.css.challenge.testingInstructor.web;

import com.css.challenge.buiness.service.InstructorService;
import com.css.challenge.model.entity.Instructor;
import com.css.challenge.presentation.controller.InstructorController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static com.css.challenge.common.InstructorConstants.INSTRUCTOR;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(InstructorController.class)
@SpringBootTest(classes = InstructorService.class)
public class InstructorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private InstructorService instructorService;

    @Test
    public void createInstructor_WithValidData_ReturnsCreated() throws Exception {
        when(instructorService.createInstructor(INSTRUCTOR)).thenReturn(INSTRUCTOR);
        mockMvc
                .perform(
                        post("/instructors").content(objectMapper.writeValueAsString(INSTRUCTOR))
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect((ResultMatcher) jsonPath("$").value(INSTRUCTOR));
    }

    @Test
    public void createInstructor_WithInvalidData_ReturnsBadRequest() throws Exception {
        Instructor emptyInstructor = new Instructor("Victor","victor@gmail.com","victor@compass.com.br","111-123-345-11",true,"12/12/1998",
                "solteiro",'M',"(87)9990-7709","Recife",123,"Recife","João","Mariana","css");
        Instructor invalidPlanet = new Instructor("","","","","","",' ',"","","","","");

        mockMvc
                .perform(
                        post("/instructors").content(this.objectMapper.writeValueAsString(emptyInstructor))
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity());
        mockMvc
                .perform(
                        post("/instructors").content(objectMapper.writeValueAsString(invalidPlanet))
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void createInstructor_WithExistingName_ReturnsConflict() throws Exception {
        when(instructorService.createInstructor(any())).thenThrow(DataIntegrityViolationException.class);

        mockMvc
                .perform(
                        post("/instructors").content(objectMapper.writeValueAsString(INSTRUCTOR))
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isConflict());
    }
}