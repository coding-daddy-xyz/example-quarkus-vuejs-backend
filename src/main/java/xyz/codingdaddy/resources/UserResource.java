package xyz.codingdaddy.resources;

import lombok.RequiredArgsConstructor;
import xyz.codingdaddy.domain.User;
import xyz.codingdaddy.domain.dto.UserDto;
import xyz.codingdaddy.mapping.UserMapper;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Path("/api/users")
@Produces("application/json")
@Consumes("application/json")
public class UserResource {

    private final UserMapper userMapper;

    @GET
    @Path("id/{id}")
    public Response find(@PathParam("id") Long id) {
        return User.findById(id)
            .map(u -> Response.ok(userMapper.toView(u)))
            .orElseGet(() -> Response.status(Response.Status.NOT_FOUND))
            .build();
    }

    @GET
    public Response findAll() {
        return Response.ok(User.<User>findAll().stream().map(userMapper::toView).collect(Collectors.toList())).build();
    }

    @Transactional
    @POST
    public Response create(UserDto userDto) {
        User user = userMapper.fromDto(userDto);
        user.persistAndFlush();
        return Response.ok(userMapper.toView(user)).build();
    }

    @DELETE
    @Path("id/{id}")
    public Response delete(@PathParam("id") Long id) {
        return User.findById(id)
            .map(u -> { u.delete(); return Response.ok(); })
            .orElseGet(() -> Response.status(Response.Status.NOT_FOUND))
            .build();
    }
}
