package br.com.gymback.application.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.gymback.application.rest.mapper.ContractMapper;
import br.com.gymback.core.fixtures.ContractFixtures;
import br.com.gymback.core.usecase.contract.CreateContractUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ContractController.class)
@ComponentScan(basePackageClasses = ContractMapper.class)
class ContractControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CreateContractUseCase createContractUseCase;

  @Test
  void shouldCreateContract() throws Exception {

    final var contract = ContractFixtures.getContract();
    when(createContractUseCase.create(any())).thenReturn(contract);

    this.mockMvc
        .perform(
            post("/contracts")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                                           "student": "1",
                                           "classRoom": "1",
                                           "discount": 0,
                                           "dueDay": 4,
                                           "contractType": "MONTHLY",
                                           "startMonth": "JANUARY",
                                           "endMonth": "DECEMBER",
                                           "startYear": 2023,
                                           "endYear": 2023
                                         }
                """))
        .andDo(print())
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.student").exists())
        .andExpect(jsonPath("$.dueDay").exists());

    verify(createContractUseCase).create(any());

  }

}