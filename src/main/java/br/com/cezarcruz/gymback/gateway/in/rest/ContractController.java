package br.com.cezarcruz.gymback.gateway.in.rest;

import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.CreateContractRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/contracts", produces = MediaType.APPLICATION_JSON_VALUE)
public class ContractController {

  @PostMapping
  public void create(@RequestBody final CreateContractRequest request) {

  }

}
