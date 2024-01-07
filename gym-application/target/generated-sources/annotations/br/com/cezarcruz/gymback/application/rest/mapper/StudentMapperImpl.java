package br.com.cezarcruz.gymback.application.rest.mapper;

import br.com.cezarcruz.gymback.application.rest.dto.request.CreateStudentRequest;
import br.com.cezarcruz.gymback.application.rest.dto.response.AddressResponse;
import br.com.cezarcruz.gymback.application.rest.dto.response.ContactResponse;
import br.com.cezarcruz.gymback.application.rest.dto.response.StudentResponse;
import br.com.cezarcruz.gymback.core.domain.ContactDomain;
import br.com.cezarcruz.gymback.core.domain.StudentDomain;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-07T20:45:44-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Singleton
@Named
public class StudentMapperImpl implements StudentMapper {

    @Inject
    private ContactMapper contactMapper;
    @Inject
    private AddressMapper addressMapper;

    @Override
    public StudentDomain toStudent(CreateStudentRequest source) {
        if ( source == null ) {
            return null;
        }

        StudentDomain.StudentDomainBuilder studentDomain = StudentDomain.builder();

        studentDomain.contacts( fromContactRequest( source.contact() ) );
        studentDomain.name( source.name() );
        studentDomain.birthDate( source.birthDate() );
        studentDomain.document( source.document() );
        studentDomain.address( addressMapper.from( source.address() ) );

        return studentDomain.build();
    }

    @Override
    public StudentResponse from(StudentDomain student) {
        if ( student == null ) {
            return null;
        }

        String id = null;
        String name = null;
        LocalDate birthDate = null;
        List<ContactResponse> contacts = null;
        AddressResponse address = null;

        id = student.id();
        name = student.name();
        birthDate = student.birthDate();
        contacts = contactDomainListToContactResponseList( student.contacts() );
        address = addressMapper.from( student.address() );

        StudentResponse studentResponse = new StudentResponse( id, name, birthDate, contacts, address );

        return studentResponse;
    }

    protected List<ContactResponse> contactDomainListToContactResponseList(List<ContactDomain> list) {
        if ( list == null ) {
            return null;
        }

        List<ContactResponse> list1 = new ArrayList<ContactResponse>( list.size() );
        for ( ContactDomain contactDomain : list ) {
            list1.add( contactMapper.from( contactDomain ) );
        }

        return list1;
    }
}
