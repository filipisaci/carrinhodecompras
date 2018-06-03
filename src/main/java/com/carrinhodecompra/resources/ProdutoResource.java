package com.carrinhodecompra.resources;

import com.carrinhodecompra.model.Produto;
import com.carrinhodecompra.services.ProdutoService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@RequestScoped
@Path("produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @Inject
    private ProdutoService service;

    @GET
    public Response findAll() {
        return Response.ok(service.findAll()).build();
    }

    @POST
    public Response insert(Produto produto) {
        return Response.status(Response.Status.CREATED)
                .entity(service.insert(produto)).build();
    }

    @PUT
    @Path("{id: \\d+}")
    public Response update(@PathParam("id") Long id, Produto produto) {
        Produto prod = service.findById(id);
        if (prod == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        if (!id.equals(produto.getId())) {
            throw new BadRequestException("ID do produto difere do ID da URL");
        }
        return Response.ok(service.update(produto)).build();
    }

    @DELETE
    @Path("{id: \\d+}")
    public Response remove(@PathParam("id") Long id) {
        service.remove(id);
        return Response.noContent().build();
    }

    @GET
    @Path("{id: \\d+}")
    @Produces({ MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML})
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(service.findById(id)).build();
    }

}

