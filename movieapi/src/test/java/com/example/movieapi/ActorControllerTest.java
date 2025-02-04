package com.example.movieapi;

import com.example.movieapi.controller.ActorController;
import com.example.movieapi.model.Actor;
import com.example.movieapi.service.ActorService;
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

@WebMvcTest(ActorController.class)
public class ActorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ActorService actorService;

    private Actor actor;

    @BeforeEach
    public void setup() {
        actor = new Actor();
        actor.setId("1");
        actor.setName("Leonardo DiCaprio");
    }

    @Test
    public void testGetAllActors() throws Exception {
        when(actorService.getAllActors()).thenReturn(List.of(actor));

        mockMvc.perform(get("/api/actors"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Leonardo DiCaprio"));
    }

    @Test
    public void testGetActorById() throws Exception {
        when(actorService.getActorById("1")).thenReturn(actor);

        mockMvc.perform(get("/api/actors/{id}", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Leonardo DiCaprio"));
    }

    @Test
    public void testCreateActor() throws Exception {
        when(actorService.createActor(any(Actor.class))).thenReturn(actor);

        mockMvc.perform(post("/api/actors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Leonardo DiCaprio\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Leonardo DiCaprio"));
    }

    @Test
    public void testUpdateActor() throws Exception {
        when(actorService.updateActor(eq("1"), any(Actor.class))).thenReturn(actor);

        mockMvc.perform(put("/api/actors/{id}", "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Leonardo DiCaprio\"}")) // Fixed JSON format
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Leonardo DiCaprio"));
    }

    @Test
    public void testDeleteActor() throws Exception {
        doNothing().when(actorService).deleteActor("1");

        mockMvc.perform(delete("/api/actors/{id}", "1"))
                .andExpect(status().isOk());
    }
}

