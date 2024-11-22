package br.com.fiap.resource;

import br.com.fiap.bo.QuizBO;
import br.com.fiap.to.QuizTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/quizes")
public class QuizResource {
    private QuizBO quizBO = new QuizBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<QuizTO> resultado = quizBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(); // código 200 (OK)
        } else {
            response = Response.status(404); // código 404 (NOT FOUND)
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/{cd_quiz}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response FindByCodigo(@PathParam("cd_quiz") Long codigo) {
        QuizTO resultado = quizBO.findByCodigo(codigo);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(); // 200 - OK
        } else {
            response = Response.status(404); // 404 - NOT FOUND
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid QuizTO quiz) {
        QuizTO resultado = quizBO.save(quiz);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null); // 201 - CREATED
        } else {
            response = Response.status(400); // 400 - BAD REQUEST
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("/{cd_quiz}")
    public Response delete(@PathParam("cd_quiz") Long codigo) {
        Response.ResponseBuilder response = null;
        if (quizBO.delete(codigo)) {
            response = Response.status(204); // 204 NO CONTENT
        } else {
            response = Response.status(404); // 404 NOT FOUND
        }
        return response.build();
    }

    @PUT
    @Path("/{cd_quiz}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid QuizTO quiz, @PathParam("cd_quiz") Long codigo) {
        quiz.setCodigo(codigo);
        QuizTO resultado = quizBO.update(quiz);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null); // 201 - CREATED
        } else {
            response = Response.status(400); // 400 - BAD REQUEST
        }
        response.entity(resultado);
        return response.build();
    }
}
