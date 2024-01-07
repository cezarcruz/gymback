package br.com.cezarcruz.gymback.application.rest.mapper;

import br.com.cezarcruz.gymback.application.rest.dto.request.CreateContractRequest;
import br.com.cezarcruz.gymback.application.rest.dto.response.ClassRoomResponse;
import br.com.cezarcruz.gymback.application.rest.dto.response.ContactResponse;
import br.com.cezarcruz.gymback.application.rest.dto.response.ContractResponse;
import br.com.cezarcruz.gymback.application.rest.dto.response.ModalityResponse;
import br.com.cezarcruz.gymback.application.rest.dto.response.PaymentResponse;
import br.com.cezarcruz.gymback.application.rest.dto.response.ScheduleResponse;
import br.com.cezarcruz.gymback.application.rest.dto.response.TeacherResponse;
import br.com.cezarcruz.gymback.core.domain.ClassRoomDomain;
import br.com.cezarcruz.gymback.core.domain.ContactDomain;
import br.com.cezarcruz.gymback.core.domain.ContractDomain;
import br.com.cezarcruz.gymback.core.domain.ModalityDomain;
import br.com.cezarcruz.gymback.core.domain.PaymentDomain;
import br.com.cezarcruz.gymback.core.domain.ScheduleDomain;
import br.com.cezarcruz.gymback.core.domain.StudentDomain;
import br.com.cezarcruz.gymback.core.domain.Teacher;
import br.com.cezarcruz.gymback.core.enums.ContactType;
import br.com.cezarcruz.gymback.core.enums.ContractStatus;
import br.com.cezarcruz.gymback.core.enums.ContractType;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-07T20:19:33-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Singleton
@Named
public class ContractMapperImpl implements ContractMapper {

    @Inject
    private PaymentMapper paymentMapper;

    @Override
    public ContractDomain fromCreateRequest(CreateContractRequest source) {
        if ( source == null ) {
            return null;
        }

        StudentDomain student = null;
        ClassRoomDomain classRoom = null;
        Month startMonth = null;
        Month endMonth = null;
        Integer startYear = null;
        Integer endYear = null;
        Integer dueDay = null;
        BigDecimal discount = null;
        ContractType contractType = null;

        student = stringToStudent( source.student() );
        classRoom = stringToClassRoom( source.classRoom() );
        startMonth = source.startMonth();
        endMonth = source.endMonth();
        startYear = source.startYear();
        endYear = source.endYear();
        dueDay = source.dueDay();
        discount = source.discount();
        contractType = source.contractType();

        String id = null;
        ContractStatus contractStatus = null;
        List<PaymentDomain> payments = null;

        ContractDomain contractDomain = new ContractDomain( id, startMonth, endMonth, startYear, endYear, dueDay, discount, contractType, contractStatus, student, classRoom, payments );

        return contractDomain;
    }

    @Override
    public ContractResponse fromModel(ContractDomain source) {
        if ( source == null ) {
            return null;
        }

        String id = null;
        Month startMonth = null;
        Month endMonth = null;
        Integer startYear = null;
        Integer endYear = null;
        Integer dueDay = null;
        BigDecimal discount = null;
        ContractType contractType = null;
        ContractStatus contractStatus = null;
        ClassRoomResponse classRoom = null;
        List<PaymentResponse> payments = null;

        id = source.getId();
        startMonth = source.getStartMonth();
        endMonth = source.getEndMonth();
        startYear = source.getStartYear();
        endYear = source.getEndYear();
        dueDay = source.getDueDay();
        discount = source.getDiscount();
        contractType = source.getContractType();
        contractStatus = source.getContractStatus();
        classRoom = classRoomDomainToClassRoomResponse( source.getClassRoom() );
        payments = paymentDomainListToPaymentResponseList( source.getPayments() );

        ContractResponse contractResponse = new ContractResponse( id, startMonth, endMonth, startYear, endYear, dueDay, discount, contractType, contractStatus, classRoom, payments );

        return contractResponse;
    }

    protected ContactResponse contactDomainToContactResponse(ContactDomain contactDomain) {
        if ( contactDomain == null ) {
            return null;
        }

        ContactType type = null;
        String value = null;

        type = contactDomain.type();
        value = contactDomain.value();

        ContactResponse contactResponse = new ContactResponse( type, value );

        return contactResponse;
    }

    protected List<ContactResponse> contactDomainListToContactResponseList(List<ContactDomain> list) {
        if ( list == null ) {
            return null;
        }

        List<ContactResponse> list1 = new ArrayList<ContactResponse>( list.size() );
        for ( ContactDomain contactDomain : list ) {
            list1.add( contactDomainToContactResponse( contactDomain ) );
        }

        return list1;
    }

    protected TeacherResponse teacherToTeacherResponse(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        String id = null;
        String name = null;
        LocalDate birthDate = null;
        List<ContactResponse> contacts = null;

        id = teacher.id();
        name = teacher.name();
        birthDate = teacher.birthDate();
        contacts = contactDomainListToContactResponseList( teacher.contacts() );

        TeacherResponse teacherResponse = new TeacherResponse( id, name, birthDate, contacts );

        return teacherResponse;
    }

    protected ModalityResponse modalityDomainToModalityResponse(ModalityDomain modalityDomain) {
        if ( modalityDomain == null ) {
            return null;
        }

        String id = null;
        String name = null;

        id = modalityDomain.id();
        name = modalityDomain.name();

        ModalityResponse modalityResponse = new ModalityResponse( id, name );

        return modalityResponse;
    }

    protected ScheduleResponse scheduleDomainToScheduleResponse(ScheduleDomain scheduleDomain) {
        if ( scheduleDomain == null ) {
            return null;
        }

        String weekDay = null;
        LocalTime startHour = null;
        LocalTime endHour = null;

        weekDay = scheduleDomain.weekDay();
        startHour = scheduleDomain.startHour();
        endHour = scheduleDomain.endHour();

        ScheduleResponse scheduleResponse = new ScheduleResponse( weekDay, startHour, endHour );

        return scheduleResponse;
    }

    protected List<ScheduleResponse> scheduleDomainListToScheduleResponseList(List<ScheduleDomain> list) {
        if ( list == null ) {
            return null;
        }

        List<ScheduleResponse> list1 = new ArrayList<ScheduleResponse>( list.size() );
        for ( ScheduleDomain scheduleDomain : list ) {
            list1.add( scheduleDomainToScheduleResponse( scheduleDomain ) );
        }

        return list1;
    }

    protected ClassRoomResponse classRoomDomainToClassRoomResponse(ClassRoomDomain classRoomDomain) {
        if ( classRoomDomain == null ) {
            return null;
        }

        String id = null;
        String name = null;
        TeacherResponse teacher = null;
        ModalityResponse modality = null;
        List<ScheduleResponse> schedule = null;

        id = classRoomDomain.id();
        name = classRoomDomain.name();
        teacher = teacherToTeacherResponse( classRoomDomain.teacher() );
        modality = modalityDomainToModalityResponse( classRoomDomain.modality() );
        schedule = scheduleDomainListToScheduleResponseList( classRoomDomain.schedule() );

        ClassRoomResponse classRoomResponse = new ClassRoomResponse( id, name, teacher, modality, schedule );

        return classRoomResponse;
    }

    protected List<PaymentResponse> paymentDomainListToPaymentResponseList(List<PaymentDomain> list) {
        if ( list == null ) {
            return null;
        }

        List<PaymentResponse> list1 = new ArrayList<PaymentResponse>( list.size() );
        for ( PaymentDomain paymentDomain : list ) {
            list1.add( paymentMapper.fromModel( paymentDomain ) );
        }

        return list1;
    }
}
