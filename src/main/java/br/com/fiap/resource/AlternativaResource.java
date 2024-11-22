package br.com.fiap.resource;

import br.com.fiap.bo.AlternativaBO;
import br.com.fiap.to.AlternativaTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/alternativas")
public class AlternativaResource {
    private AlternativaBO alternativaBO = new AlternativaBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<AlternativaTO> resultado = alternativaBO.findAll();
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
    @Path("/{cd_alternativa}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response FindByCodigo(@PathParam("cd_alternativa") Long codigo) {
        AlternativaTO resultado = alternativaBO.findByCodigo(codigo);
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
    public Response save(@Valid AlternativaTO alternativa) {
        AlternativaTO resultado = alternativaBO.save(alternativa);
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
    @Path("/{cd_alternativa}")
    public Response delete(@PathParam("cd_alternativa") Long codigo) {
        Response.ResponseBuilder response = null;
        if (alternativaBO.delete(codigo)) {
            response = Response.status(204); // 204 NO CONTENT
        } else {
            response = Response.status(404); // 404 NOT FOUND
        }
        return response.build();
    }

    @PUT
    @Path("/{cd_alternativa}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid AlternativaTO alternativa, @PathParam("cd_alternativa") Long codigo) {
        alternativa.setCodigo(codigo);
        AlternativaTO resultado = alternativaBO.update(alternativa);
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
