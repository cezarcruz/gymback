package br.com.cezarcruz.application.rest;

import br.com.cezarcruz.application.rest.dto.request.CreateContractRequest;
import br.com.cezarcruz.application.rest.dto.response.ContractResponse;
import br.com.cezarcruz.application.rest.mapper.ContractMapper;
import br.com.cezarcruz.core.usecase.contract.CreateContractUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/contracts", produces = MediaType.APPLICATION_JSON_VALUE)
public class ContractController {

  private final CreateContractUseCase createContractUseCase;
  private final ContractMapper contractMapper;

  @PostMapping
  public ContractResponse create(@Valid @RequestBody final CreateContractRequest request) {
    var contract = contractMapper.fromCreateRequest(request);
    var created = createContractUseCase.create(contract);
    return contractMapper.fromModel(created);
  }

}
