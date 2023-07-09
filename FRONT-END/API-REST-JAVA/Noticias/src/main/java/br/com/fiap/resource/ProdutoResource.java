package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.NoticiasBO;
import br.com.fiap.to.NoticiasTO;

@Path("/noticias")
public class ProdutoResource {

	NoticiasBO pb = new NoticiasBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<NoticiasTO> buscar() {
		return pb.listar();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public NoticiasTO buscar(@PathParam("id") int id) {
		return pb.listar(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(NoticiasTO noticias, @Context UriInfo uriInfo) {

		// INSERIR NA BASE
		pb.cadastrar(noticias);

		// CONSTRUIR O PATH DE RETORNO
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(noticias.getCodigo()));

		// RETORNA O PATH E O STATUS 201
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualiza(NoticiasTO noticias, @PathParam("id") int id) {
		noticias.setCodigo(id);
		pb.atualiza(noticias);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public void excluir(@PathParam("id") int id) {
		pb.remover(id);
	}

}
