package br.com.cezarcruz.gymback.application.rest.mapper;

import br.com.cezarcruz.gymback.application.rest.dto.request.CreateAddressRequest;
import br.com.cezarcruz.gymback.application.rest.dto.response.AddressResponse;
import br.com.cezarcruz.gymback.core.domain.AddressDomain;
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
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressDomain from(CreateAddressRequest source) {
        if ( source == null ) {
            return null;
        }

        AddressDomain.AddressDomainBuilder addressDomain = AddressDomain.builder();

        addressDomain.addressNumber( source.num() );
        addressDomain.zipcode( source.zipcode() );
        addressDomain.street( source.street() );
        addressDomain.state( source.state() );
        addressDomain.city( source.city() );
        addressDomain.neighborhood( source.neighborhood() );

        return addressDomain.build();
    }

    @Override
    public AddressResponse from(AddressDomain source) {
        if ( source == null ) {
            return null;
        }

        String id = null;
        String zipcode = null;
        String street = null;
        String neighborhood = null;
        String addressNumber = null;
        String state = null;
        String city = null;

        id = source.id();
        zipcode = source.zipcode();
        street = source.street();
        neighborhood = source.neighborhood();
        addressNumber = source.addressNumber();
        state = source.state();
        city = source.city();

        AddressResponse addressResponse = new AddressResponse( id, zipcode, street, neighborhood, addressNumber, state, city );

        return addressResponse;
    }
}
