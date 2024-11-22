package br.com.fiap.resource;

import br.com.fiap.bo.ArtigoBO;
import br.com.fiap.to.ArtigoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/artigos")
public class ArtigoResource {
    private ArtigoBO artigoBO = new ArtigoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<ArtigoTO> resultado = artigoBO.findAll();
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
    @Path("/{cd_artigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response FindByCodigo(@PathParam("cd_artigo") Long codigo) {
        ArtigoTO resultado = artigoBO.findByCodigo(codigo);
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
    public Response save(@Valid ArtigoTO artigo) {
        ArtigoTO resultado = artigoBO.save(artigo);
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
    @Path("/{cd_artigo}")
    public Response delete(@PathParam("cd_artigo") Long codigo) {
        Response.ResponseBuilder response = null;
        if (artigoBO.delete(codigo)) {
            response = Response.status(204); // 204 NO CONTENT
        } else {
            response = Response.status(404); // 404 NOT FOUND
        }
        return response.build();
    }

    @PUT
    @Path("/{cd_artigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid ArtigoTO artigo, @PathParam("cd_artigo") Long codigo) {
        artigo.setCodigo(codigo);
        ArtigoTO resultado = artigoBO.update(artigo);
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
