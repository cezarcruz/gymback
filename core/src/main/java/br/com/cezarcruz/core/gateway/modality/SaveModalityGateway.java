package br.com.cezarcruz.core.gateway.modality;


import br.com.cezarcruz.core.domain.ModalityDomain;

public interface SaveModalityGateway {

  ModalityDomain save(final ModalityDomain modality);

}
