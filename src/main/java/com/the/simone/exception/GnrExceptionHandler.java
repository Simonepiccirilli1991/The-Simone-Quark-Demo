package com.the.simone.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GnrExceptionHandler implements ExceptionMapper<GnrException> {
    @Override
    public Response toResponse(GnrException e) {
        log.error("Error has been throw, with error: {}", e);
        return Response.serverError().entity(e).build();
    }
}
