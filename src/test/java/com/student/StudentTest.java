package com.student;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.model.GenderEnum;
import com.student.model.StudentModel;

public class StudentTest extends StudentCurdApplicationTests {
	@Autowired
	private WebApplicationContext webConApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webConApplicationContext).build();
	}

	@Test
	public void testStudent() throws Exception {
		mockMvc.perform(get("/api/v1/student").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.studId").value(1));

	}

	@Test
	public void testAllStudent() throws Exception {
		mockMvc.perform(get("/api/v1/student").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void testAddStudent() throws Exception{
	
		StudentModel stud=new StudentModel();
		stud.setStudFirstName("adsad");
		stud.setStudLastName("kjjk");
		stud.setGender(GenderEnum.M);
		stud.setDateOfBirth( Date.valueOf("2000-04-04"));
		mockMvc.perform(post("/api/v1/student/add").contentType(MediaType.APPLICATION_JSON).content(toJson(stud))).andExpect(status().isOk());
		assertTrue("Added", true);
	}
	
	public static String toJson(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
