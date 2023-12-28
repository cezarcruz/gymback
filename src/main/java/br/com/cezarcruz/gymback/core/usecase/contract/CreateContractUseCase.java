package br.com.cezarcruz.gymback.core.usecase.contract;

import br.com.cezarcruz.gymback.core.domain.Contract;
import br.com.cezarcruz.gymback.gateway.out.gateway.contract.SaveContractGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateContractUseCase {

  private final SaveContractGateway saveContractGateway;

  public Contract create(final Contract contract) {



    return saveContractGateway.save(contract);
  }

}
