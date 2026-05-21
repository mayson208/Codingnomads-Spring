/* CodingNomads (C)2024 */
package com.codingnomads.springtest.lab;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.codingnomads.springtest.lab.entity.Movie;
import com.codingnomads.springtest.lab.service.MovieService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = SpringTestLab.class)
@AutoConfigureMockMvc
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @Test
    public void testGetAllMoviesSuccess() throws Exception {
        when(movieService.getAllMovies())
                .thenReturn(List.of(
                        Movie.builder().id(1L).name("The Shawshank Redemption").rating(9.3).build(),
                        Movie.builder().id(2L).name("The Pursuit of Happyness").rating(8.0).build()));

        mockMvc.perform(get("/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name").value("The Shawshank Redemption"))
                .andExpect(jsonPath("$[1].name").value("The Pursuit of Happyness"));
    }

    @Test
    public void testGetAllMoviesFailure() throws Exception {
        mockMvc.perform(get("/nonexistent"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetAllMoviesSuccessMockService() throws Exception {
        when(movieService.getAllMovies())
                .thenReturn(List.of(
                        Movie.builder().id(1L).name("Inception").rating(8.8).build()));

        mockMvc.perform(get("/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Inception"))
                .andExpect(jsonPath("$[0].rating").value(8.8));
    }
}
