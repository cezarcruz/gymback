package br.com.cezarcruz.gymback.application.rest.mapper;

import br.com.cezarcruz.gymback.application.rest.dto.request.CreateClassRoomRequest;
import br.com.cezarcruz.gymback.application.rest.dto.request.CreateScheduleRequest;
import br.com.cezarcruz.gymback.application.rest.dto.response.ClassRoomResponse;
import br.com.cezarcruz.gymback.application.rest.dto.response.ModalityResponse;
import br.com.cezarcruz.gymback.application.rest.dto.response.ScheduleResponse;
import br.com.cezarcruz.gymback.application.rest.dto.response.TeacherResponse;
import br.com.cezarcruz.gymback.core.domain.ClassRoomDomain;
import br.com.cezarcruz.gymback.core.domain.ModalityDomain;
import br.com.cezarcruz.gymback.core.domain.ScheduleDomain;
import br.com.cezarcruz.gymback.core.domain.Teacher;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
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
public class ClassRoomMapperImpl implements ClassRoomMapper {

    @Inject
    private ModalityMapper modalityMapper;
    @Inject
    private TeacherMapper teacherMapper;
    @Inject
    private ScheduleMapper scheduleMapper;

    @Override
    public ClassRoomDomain from(CreateClassRoomRequest createClassRoomRequest) {
        if ( createClassRoomRequest == null ) {
            return null;
        }

        ClassRoomDomain.ClassRoomDomainBuilder classRoomDomain = ClassRoomDomain.builder();

        classRoomDomain.teacher( createClassRoomRequestToTeacher( createClassRoomRequest ) );
        classRoomDomain.modality( createClassRoomRequestToModalityDomain( createClassRoomRequest ) );
        classRoomDomain.name( createClassRoomRequest.name() );
        classRoomDomain.schedule( createScheduleRequestListToScheduleDomainList( createClassRoomRequest.schedule() ) );
        classRoomDomain.value( createClassRoomRequest.value() );

        return classRoomDomain.build();
    }

    @Override
    public ClassRoomResponse from(ClassRoomDomain classRoom) {
        if ( classRoom == null ) {
            return null;
        }

        String id = null;
        String name = null;
        TeacherResponse teacher = null;
        ModalityResponse modality = null;
        List<ScheduleResponse> schedule = null;

        id = classRoom.id();
        name = classRoom.name();
        teacher = teacherMapper.fromDomain( classRoom.teacher() );
        modality = modalityMapper.from( classRoom.modality() );
        schedule = scheduleDomainListToScheduleResponseList( classRoom.schedule() );

        ClassRoomResponse classRoomResponse = new ClassRoomResponse( id, name, teacher, modality, schedule );

        return classRoomResponse;
    }

    protected Teacher createClassRoomRequestToTeacher(CreateClassRoomRequest createClassRoomRequest) {
        if ( createClassRoomRequest == null ) {
            return null;
        }

        Teacher.TeacherBuilder teacher = Teacher.builder();

        teacher.id( createClassRoomRequest.teacher() );

        return teacher.build();
    }

    protected ModalityDomain createClassRoomRequestToModalityDomain(CreateClassRoomRequest createClassRoomRequest) {
        if ( createClassRoomRequest == null ) {
            return null;
        }

        ModalityDomain.ModalityDomainBuilder modalityDomain = ModalityDomain.builder();

        modalityDomain.id( createClassRoomRequest.modality() );

        return modalityDomain.build();
    }

    protected List<ScheduleDomain> createScheduleRequestListToScheduleDomainList(List<CreateScheduleRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<ScheduleDomain> list1 = new ArrayList<ScheduleDomain>( list.size() );
        for ( CreateScheduleRequest createScheduleRequest : list ) {
            list1.add( scheduleMapper.from( createScheduleRequest ) );
        }

        return list1;
    }

    protected List<ScheduleResponse> scheduleDomainListToScheduleResponseList(List<ScheduleDomain> list) {
        if ( list == null ) {
            return null;
        }

        List<ScheduleResponse> list1 = new ArrayList<ScheduleResponse>( list.size() );
        for ( ScheduleDomain scheduleDomain : list ) {
            list1.add( scheduleMapper.from( scheduleDomain ) );
        }

        return list1;
    }
}
