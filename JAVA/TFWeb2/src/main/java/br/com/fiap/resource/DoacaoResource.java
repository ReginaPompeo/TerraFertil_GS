package br.com.fiap.resource;

import java.sql.SQLException;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.DoacaoBO;
import br.com.fiap.to.DoacaoTO;

@Path("/rank")
public class DoacaoResource {

	DoacaoBO doacaobo = new DoacaoBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<DoacaoTO> buscarDoacoes() {
		return doacaobo.exibirDadosDoacaoBo();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public DoacaoTO buscar(@PathParam("id") int id) {
		return doacaobo.exibirDadosDoacaoBoId(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(DoacaoTO doacao, @Context UriInfo uriInfo) throws SQLException {

		// INSERIR NA BASE
		doacaobo.inserirDoacao(doacao);

		// CONSTRUIR O PATH DE RETORNO
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(doacao.getId()));

		// RETORNA O PATH E O STATUS 201
		return Response.created(builder.build()).build();
	}

	@DELETE
	@Path("/{id}")
	public void excluir(@PathParam("id") int id) throws SQLException {
		doacaobo.excluirDoacao(id);
	}

}