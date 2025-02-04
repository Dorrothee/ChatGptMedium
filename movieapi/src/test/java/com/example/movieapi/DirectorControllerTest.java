package com.example.movieapi;

import com.example.movieapi.controller.DirectorController;
import com.example.movieapi.model.Director;
import com.example.movieapi.service.DirectorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DirectorController.class)
public class DirectorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private DirectorService directorService;

    private Director director;

    @BeforeEach
    public void setup() {
        director = new Director();
        director.setId("1");
        director.setName("Christopher Nolan");
    }

    @Test
    public void testGetAllDirectors() throws Exception {
        when(directorService.getAllDirectors()).thenReturn(List.of(director));

        mockMvc.perform(get("/api/directors"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Christopher Nolan"));
    }

    @Test
    public void testGetDirectorById() throws Exception {
        when(directorService.getDirectorById("1")).thenReturn(director);

        mockMvc.perform(get("/api/directors/{id}", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Christopher Nolan"));
    }

    @Test
    public void testCreateDirector() throws Exception {
        when(directorService.createDirector(any(Director.class))).thenReturn(director);

        mockMvc.perform(post("/api/directors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Christopher Nolan\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Christopher Nolan"));
    }

    @Test
    public void testUpdateDirector() throws Exception {
        when(directorService.updateDirector(eq("1"), any(Director.class))).thenReturn(director);

        mockMvc.perform(put("/api/directors/{id}", "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Christopher Nolan\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Christopher Nolan"));
    }

    @Test
    public void testDeleteDirector() throws Exception {
        doNothing().when(directorService).deleteDirector("1");

        mockMvc.perform(delete("/api/directors/{id}", "1"))
                .andExpect(status().isOk());
    }
}

