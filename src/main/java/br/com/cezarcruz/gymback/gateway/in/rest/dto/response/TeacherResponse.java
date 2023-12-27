package br.com.cezarcruz.gymback.gateway.in.rest.dto.response;

import java.util.List;

public record TeacherResponse(
    String id,
    String name,

    List<ContactResponse> contacts
) {

}
