package com.mehdisarf.exceptions;

import com.mehdisarf.models.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/*
    mikham vaqti ye ex part mishe, return konam ye JSON response ii ro.
    raveshesh ine: Map the exception to a response.
    tu jax-rs, map kardane ye expcetion be ye response ro ba classi be name e
    ExceptionMapper anjam midim.

    hameye classaye ExceptionMapper bayad interfacii be name ExceptionMapper
    ro implement konan. interface e ExceptionMapper, generic type e. va inja
    type argument mishe hamun exception ii ke mikham in ExceptionMapper map esh kone
    baram be ye response ii.

 */

/*
    *ye tozih:
    Your runtime will come with a number of predefined providers that will be responsible
    for implementing a base level of functionality (e.g for mapping to and from XML,
    translating the most common exceptions etc etc).
    You can also create your own providers as needed.

    *tozihe yeki dg:
    To do certain activities such as Filtering-Request/Response, Exception Handling, the JAX-RS has its own default implementation logic. However, it allows users to provider thier own implementation as well.
    To provide our own implementation we need to implement the appropriate classes
    by specifying them with @Provider annotation.

    JAX-RS will do a round of scanning to find the existance of any such
    user-defined implementation by seaching for @Provider annotation.
 */

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {
    @Override
    public Response toResponse(DataNotFoundException exception) {

        ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 404, "www.mehdisarf.com");

        return Response.status(Response.Status.NOT_FOUND)
                .entity(errorMessage)
                .build();
    }
}
