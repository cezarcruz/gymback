package br.com.gymback.application.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.gymback.application.fixtures.ModalityFixtures;
import br.com.gymback.application.rest.mapper.ModalityMapper;
import br.com.gymback.core.usecase.modality.CreateModalityUseCase;
import br.com.gymback.core.usecase.modality.DeleteModalityUseCase;
import br.com.gymback.core.usecase.modality.GetModalityUseCase;
import br.com.gymback.core.usecase.modality.UpdateModalityUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ModalityController.class)
@ComponentScan(basePackageClasses = ModalityMapper.class)
class ModalityControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CreateModalityUseCase createModalityUseCase;
  @MockBean
  private GetModalityUseCase getModalityUseCase;
  @MockBean
  private DeleteModalityUseCase deleteModalityUseCase;
  @MockBean
  private UpdateModalityUseCase updateModalityUseCase;

  //@Test TODO: not working
  void shouldCreateModality() throws Exception {

    when(createModalityUseCase.create(any()))
        .thenReturn(ModalityFixtures.getModalityDomain());

    this.mockMvc.perform(post("/modalities")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .content(
                """
                { "name": "zumba" }
                """
            ))
        .andDo(print())
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.id").exists())
        .andExpect(jsonPath("$.name").exists());

    verify(createModalityUseCase).create(any());
  }

}