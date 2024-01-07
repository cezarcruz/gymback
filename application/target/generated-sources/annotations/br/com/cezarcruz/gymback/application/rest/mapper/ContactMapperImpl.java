package br.com.cezarcruz.gymback.application.rest.mapper;

import br.com.cezarcruz.gymback.application.rest.dto.request.CreateContactRequest;
import br.com.cezarcruz.gymback.application.rest.dto.request.UpdateContactRequest;
import br.com.cezarcruz.gymback.application.rest.dto.response.ContactResponse;
import br.com.cezarcruz.gymback.core.domain.ContactDomain;
import br.com.cezarcruz.gymback.core.enums.ContactType;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-07T20:19:33-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Singleton
@Named
public class ContactMapperImpl implements ContactMapper {

    @Override
    public ContactDomain from(CreateContactRequest source) {
        if ( source == null ) {
            return null;
        }

        String id = null;
        ContactType type = null;
        String value = null;

        ContactDomain contactDomain = new ContactDomain( id, type, value );

        return contactDomain;
    }

    @Override
    public ContactResponse from(ContactDomain source) {
        if ( source == null ) {
            return null;
        }

        ContactType type = null;
        String value = null;

        type = source.type();
        value = source.value();

        ContactResponse contactResponse = new ContactResponse( type, value );

        return contactResponse;
    }

    @Override
    public ContactDomain from(UpdateContactRequest source) {
        if ( source == null ) {
            return null;
        }

        String id = null;
        ContactType type = null;
        String value = null;

        ContactDomain contactDomain = new ContactDomain( id, type, value );

        return contactDomain;
    }
}
