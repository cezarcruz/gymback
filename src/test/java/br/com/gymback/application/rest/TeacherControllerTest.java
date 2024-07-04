/* Under MIT License (C)2024 */
package br.com.gymback.application.rest;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.gymback.application.rest.mapper.TeacherMapper;
import br.com.gymback.core.usecase.teacher.CreateTeacherUseCase;
import br.com.gymback.core.usecase.teacher.DeleteTeacherUseCase;
import br.com.gymback.core.usecase.teacher.GetTeacherUseCase;
import br.com.gymback.core.usecase.teacher.UpdateTeacherUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(TeacherController.class)
@ComponentScan(basePackageClasses = TeacherMapper.class)
class TeacherControllerTest {

  @Autowired private MockMvc mockMvc;

  @MockBean private CreateTeacherUseCase createTeacherUseCase;
  @MockBean private GetTeacherUseCase getTeacherUseCase;
  @MockBean private UpdateTeacherUseCase updateTeacherUseCase;
  @MockBean private DeleteTeacherUseCase deleteTeacherUseCase;

  @Test
  void shouldNotCreateTeacherCausePostInvalid() throws Exception {

    this.mockMvc
        .perform(
            post("/teachers")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
            {"name": "Pedro Pederneiras" }
            """))
        .andDo(print())
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$", hasSize(1)));
  }
}
