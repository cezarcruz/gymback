package br.com.cezarcruz.gymback.application.rest.mapper;

import br.com.cezarcruz.gymback.application.rest.dto.request.CreateModalityRequest;
import br.com.cezarcruz.gymback.application.rest.dto.request.UpdateModalityRequest;
import br.com.cezarcruz.gymback.application.rest.dto.response.ModalityResponse;
import br.com.cezarcruz.gymback.core.domain.ModalityDomain;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-07T20:45:44-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Singleton
@Named
public class ModalityMapperImpl implements ModalityMapper {

    @Override
    public ModalityDomain toModality(CreateModalityRequest createModalityRequest) {
        if ( createModalityRequest == null ) {
            return null;
        }

        ModalityDomain.ModalityDomainBuilder modalityDomain = ModalityDomain.builder();

        modalityDomain.name( createModalityRequest.name() );

        return modalityDomain.build();
    }

    @Override
    public ModalityResponse from(ModalityDomain createdModality) {
        if ( createdModality == null ) {
            return null;
        }

        String id = null;
        String name = null;

        id = createdModality.id();
        name = createdModality.name();

        ModalityResponse modalityResponse = new ModalityResponse( id, name );

        return modalityResponse;
    }

    @Override
    public ModalityDomain toModality(String id, UpdateModalityRequest updateModalityRequest) {
        if ( id == null && updateModalityRequest == null ) {
            return null;
        }

        ModalityDomain.ModalityDomainBuilder modalityDomain = ModalityDomain.builder();

        if ( updateModalityRequest != null ) {
            modalityDomain.name( updateModalityRequest.name() );
        }
        modalityDomain.id( id );

        return modalityDomain.build();
    }
}
