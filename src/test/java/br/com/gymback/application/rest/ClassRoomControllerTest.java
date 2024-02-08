/* Under MIT License (C)2024 */
package br.com.gymback.application.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.gymback.application.rest.mapper.ClassRoomMapper;
import br.com.gymback.core.domain.ClassRoomDomain;
import br.com.gymback.core.domain.PageDomain;
import br.com.gymback.core.fixtures.ClassRoomFixtures;
import br.com.gymback.core.usecase.classroom.CreateClassRoomUseCase;
import br.com.gymback.core.usecase.classroom.GetClassRoomUseCase;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ClassRoomController.class)
@ComponentScan(basePackageClasses = ClassRoomMapper.class)
class ClassRoomControllerTest {

  @Autowired private MockMvc mockMvc;

  @MockBean private CreateClassRoomUseCase createClassRoomUseCase;

  @MockBean private GetClassRoomUseCase getClassRoomUseCase;

  @Test
  void shouldCreate() throws Exception {

    final var classRoom = ClassRoomFixtures.getClassRoom();
    when(createClassRoomUseCase.create(classRoom)).thenReturn(classRoom);

    this.mockMvc
        .perform(
            post("/classes")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    """
                    {
                                "name": "Aulas de Perda de Peso",
                                "teacher": "1",
                                "modality": "2",
                                "value": 85.90,
                                "schedule": [
                                  {
                                    "weekDay": "mon",
                                    "startHour": "13:00",
                                    "endHour": "14:30"
                                  },
                                  {
                                    "weekDay": "thu",
                                    "startHour": "13:00",
                                    "endHour": "14:30"
                                  },
                                  {
                                    "weekDay": "fri",
                                    "startHour": "13:00",
                                    "endHour": "14:30"
                                  }
                                ]
                              }
                """))
        .andDo(print())
        .andExpect(status().isCreated());
  }

  @Test
  void shouldFindAll() throws Exception {

    final var classRoom = ClassRoomFixtures.getClassRoom();
    final var page = new PageDomain<ClassRoomDomain>(0, 10);

    when(getClassRoomUseCase.findAll(any())).thenReturn(page.withElements(List.of(classRoom)));

    this.mockMvc
        .perform(
            get("/classes?page=0&size=1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").exists());
  }
}
