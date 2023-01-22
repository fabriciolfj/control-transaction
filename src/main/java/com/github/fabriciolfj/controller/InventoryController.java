package com.github.fabriciolfj.controller;

import com.github.fabriciolfj.entity.Inventory;
import com.github.fabriciolfj.service.InventoryService;
import lombok.RequiredArgsConstructor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;

@Path("/api/v1/inventories")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService service;

    @POST
    public Response create(final Inventory inventory) {
        inventory.setDateRegistration(LocalDateTime.now());
        service.save(inventory);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/exit/{product}/{quantidade}")
    public Response update(@PathParam("product") final String product, @PathParam("quantidade") final Integer quantidade) {
        service.updateInventory(product, quantidade);
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
