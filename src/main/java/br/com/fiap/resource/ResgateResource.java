package br.com.fiap.resource;

import br.com.fiap.bo.ResgateBO;
import br.com.fiap.to.ResgateTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/resgates")
public class ResgateResource {
    private ResgateBO resgateBO = new ResgateBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<ResgateTO> resultado = resgateBO.findAll();
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
    @Path("/{cd_resgate}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response FindByCodigo(@PathParam("cd_resgate") Long codigo) {
        ResgateTO resultado = resgateBO.findByCodigo(codigo);
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
    public Response save(@Valid ResgateTO resgate) {
        ResgateTO resultado = resgateBO.save(resgate);
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
    @Path("/{cd_resgate}")
    public Response delete(@PathParam("cd_resgate") Long codigo) {
        Response.ResponseBuilder response = null;
        if (resgateBO.delete(codigo)) {
            response = Response.status(204); // 204 NO CONTENT
        } else {
            response = Response.status(404); // 404 NOT FOUND
        }
        return response.build();
    }

    @PUT
    @Path("/{cd_resgate}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid ResgateTO resgate, @PathParam("cd_resgate") Long codigo) {
        resgate.setCodigo(codigo);
        ResgateTO resultado = resgateBO.update(resgate);
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
