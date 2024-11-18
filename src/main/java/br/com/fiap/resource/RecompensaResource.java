package br.com.fiap.resource;

import br.com.fiap.bo.RecompensaBO;
import br.com.fiap.to.RecompensaTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/recompensas")
public class RecompensaResource {
    private RecompensaBO recompensaBO = new RecompensaBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<RecompensaTO> resultado = recompensaBO.findAll();
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
    @Path("/{cd_recompensa}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response FindByCodigo(@PathParam("cd_recompensa") Long codigo) {
        RecompensaTO resultado = recompensaBO.findByCodigo(codigo);
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
    public Response save(@Valid RecompensaTO recompensa) {
        RecompensaTO resultado = recompensaBO.save(recompensa);
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
    @Path("/{cd_recompensa}")
    public Response delete(@PathParam("cd_recompensa") Long codigo) {
        Response.ResponseBuilder response = null;
        if (recompensaBO.delete(codigo)) {
            response = Response.status(204); // 204 NO CONTENT
        } else {
            response = Response.status(404); // 404 NOT FOUND
        }
        return response.build();
    }

    @PUT
    @Path("/{cd_recompensa}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid RecompensaTO recompensa, @PathParam("cd_recompensa") Long codigo) {
        recompensa.setCodigo(codigo);
        RecompensaTO resultado = recompensaBO.update(recompensa);
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
