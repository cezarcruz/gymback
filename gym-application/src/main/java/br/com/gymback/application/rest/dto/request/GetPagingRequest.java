package br.com.gymback.application.rest.dto.request;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;

public record GetPagingRequest(

    @Parameter(in = ParameterIn.QUERY, example = "20")
    Integer size,

    @Parameter(in = ParameterIn.QUERY, example = "0")
    Integer page
) {
    public GetPagingRequest {
        if (size == null) {
            size = 20;
        }

        if (page == null) {
            page = 0;
        }
    }
}
