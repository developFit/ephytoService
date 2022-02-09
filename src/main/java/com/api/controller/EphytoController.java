package com.api.controller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.api.DTO.EnvioRequestDto;
import com.ephyto.client.HubClient;

import _int.ippc.ephyto.HUB_Entities.Envelope;

@Path("/ephyto/enviar") 
@Produces(MediaType.APPLICATION_JSON) 
//@Consumes(MediaType.APPLICATION_XML)
public class EphytoController {
	
	@GET 
    public Response envio(EnvioRequestDto envioDto) throws Exception {
		HubClient cliente = new HubClient();
		Envelope env = (Envelope) cliente.DeliverEnvelope(envioDto.getFrom(), envioDto.getTo(), envioDto.getType(), envioDto.getStatus(), envioDto.getCertificateNumber(), envioDto.getXml());
		
		return Response.ok(cliente.deliverEnvelope(env),MediaType.APPLICATION_JSON).build();   
    }

}
