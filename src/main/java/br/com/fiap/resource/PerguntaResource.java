package br.com.fiap.resource;

import br.com.fiap.bo.PerguntaBO;
import br.com.fiap.to.PerguntaTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/perguntas")
public class PerguntaResource {
    private PerguntaBO perguntaBO = new PerguntaBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<PerguntaTO> resultado = perguntaBO.findAll();
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
    @Path("/{cd_pergunta}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response FindByCodigo(@PathParam("cd_pergunta") Long codigo) {
        PerguntaTO resultado = perguntaBO.findByCodigo(codigo);
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
    public Response save(@Valid PerguntaTO pergunta) {
        PerguntaTO resultado = perguntaBO.save(pergunta);
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
    @Path("/{cd_pergunta}")
    public Response delete(@PathParam("cd_pergunta") Long codigo) {
        Response.ResponseBuilder response = null;
        if (perguntaBO.delete(codigo)) {
            response = Response.status(204); // 204 NO CONTENT
        } else {
            response = Response.status(404); // 404 NOT FOUND
        }
        return response.build();
    }

    @PUT
    @Path("/{cd_pergunta}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid PerguntaTO pergunta, @PathParam("cd_pergunta") Long codigo) {
        pergunta.setCodigo(codigo);
        PerguntaTO resultado = perguntaBO.update(pergunta);
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
