package com.api.prueba;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
//import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.api.DTO.EnvioRequestDto;
import com.api.conection.SQLDatabaseConnection;
import com.api.exceptions.HubClientException;
import com.api.xml.CrearXmlDatos;
import com.ephyto.client.HubClient;
import com.ephyto.client.UpdateData;

import _int.ippc.ephyto.IDeliveryService;
import _int.ippc.ephyto.HUB_Entities.Envelope;

@Path("/enviar")
@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_XML)
public class HubEnvio {

	@GET
	public Response envio() throws Exception {
		HubClient cliente = new HubClient();
		Envelope env = (Envelope) cliente.DeliverEnvelope("BO", "PY", "851", 70, "BO-784754452", "ABC18111111");
		return Response.ok(cliente.deliverEnvelope(env), MediaType.APPLICATION_JSON).build();
	}

	@POST
	@Path("/testPost")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response testPost(EnvioRequestDto request)
			throws Exception {

		HubClient cliente = new HubClient();
		Envelope env = (Envelope) cliente.DeliverEnvelope(request.getFrom(), request.getTo(), request.getType(), request.getStatus(), request.getCertificateNumber(), request.getXml());
		// cliente.pullAcknowledge();
		// return Response.ok(cliente.deliverEnvelope(env),
		// MediaType.APPLICATION_JSON).build();
		return Response.ok(env, MediaType.APPLICATION_JSON).build();
	}

}
