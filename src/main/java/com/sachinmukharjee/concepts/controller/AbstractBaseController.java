package com.sachinmukharjee.concepts.controller;

import com.sachinmukharjee.concepts.dto.Response;
import com.sachinmukharjee.concepts.utils.AppConstants;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;

public class AbstractBaseController {


    protected <T> ResponseEntity<Response<T>> createSuccessResponse(T data) {
        Response<T> response = new Response<>(getRequestId(), true, data,null);
        return ResponseEntity.ok(response);
    }


    protected  String getRequestId(){
        String requestId = MDC.get(AppConstants.TRACE_ID);
        return requestId;
    }
}
