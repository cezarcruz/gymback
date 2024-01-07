package br.com.cezarcruz.gymback.application.rest.mapper;

import br.com.cezarcruz.gymback.application.rest.dto.request.CreateTeacherRequest;
import br.com.cezarcruz.gymback.application.rest.dto.request.UpdateContactRequest;
import br.com.cezarcruz.gymback.application.rest.dto.request.UpdateTeacherRequest;
import br.com.cezarcruz.gymback.application.rest.dto.response.ContactResponse;
import br.com.cezarcruz.gymback.application.rest.dto.response.PageResponse;
import br.com.cezarcruz.gymback.application.rest.dto.response.TeacherResponse;
import br.com.cezarcruz.gymback.core.domain.ContactDomain;
import br.com.cezarcruz.gymback.core.domain.PageDomain;
import br.com.cezarcruz.gymback.core.domain.Teacher;
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
public class TeacherMapperImpl implements TeacherMapper {

    @Inject
    private ContactMapper contactMapper;

    @Override
    public Teacher fromRequest(CreateTeacherRequest createTeacherRequest) {
        if ( createTeacherRequest == null ) {
            return null;
        }

        Teacher.TeacherBuilder teacher = Teacher.builder();

        teacher.contacts( fromContactRequest( createTeacherRequest.contact() ) );
        teacher.name( createTeacherRequest.name() );
        teacher.birthDate( createTeacherRequest.birthDate() );

        return teacher.build();
    }

    @Override
    public TeacherResponse fromDomain(Teacher createdTeacher) {
        if ( createdTeacher == null ) {
            return null;
        }

        String id = null;
        String name = null;
        LocalDate birthDate = null;
        List<ContactResponse> contacts = null;

        id = createdTeacher.id();
        name = createdTeacher.name();
        birthDate = createdTeacher.birthDate();
        contacts = contactDomainListToContactResponseList( createdTeacher.contacts() );

        TeacherResponse teacherResponse = new TeacherResponse( id, name, birthDate, contacts );

        return teacherResponse;
    }

    @Override
    public PageResponse<TeacherResponse> fromPageDomain(PageDomain<Teacher> teacher) {
        if ( teacher == null ) {
            return null;
        }

        int page = 0;
        int size = 0;
        long totalElements = 0L;
        int totalPages = 0;
        List<TeacherResponse> elements = null;

        page = teacher.getPage();
        size = teacher.getSize();
        totalElements = teacher.getTotalElements();
        totalPages = teacher.getTotalPages();
        elements = teacherListToTeacherResponseList( teacher.getElements() );

        PageResponse<TeacherResponse> pageResponse = new PageResponse<TeacherResponse>( page, size, totalElements, totalPages, elements );

        return pageResponse;
    }

    @Override
    public Teacher toTeacher(String id, UpdateTeacherRequest updateTeacherRequest) {
        if ( id == null && updateTeacherRequest == null ) {
            return null;
        }

        Teacher.TeacherBuilder teacher = Teacher.builder();

        if ( updateTeacherRequest != null ) {
            teacher.name( updateTeacherRequest.name() );
            teacher.birthDate( updateTeacherRequest.birthDate() );
            teacher.contacts( updateContactRequestListToContactDomainList( updateTeacherRequest.contacts() ) );
        }
        teacher.id( id );

        return teacher.build();
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

    protected List<TeacherResponse> teacherListToTeacherResponseList(List<Teacher> list) {
        if ( list == null ) {
            return null;
        }

        List<TeacherResponse> list1 = new ArrayList<TeacherResponse>( list.size() );
        for ( Teacher teacher : list ) {
            list1.add( fromDomain( teacher ) );
        }

        return list1;
    }

    protected List<ContactDomain> updateContactRequestListToContactDomainList(List<UpdateContactRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<ContactDomain> list1 = new ArrayList<ContactDomain>( list.size() );
        for ( UpdateContactRequest updateContactRequest : list ) {
            list1.add( contactMapper.from( updateContactRequest ) );
        }

        return list1;
    }
}
