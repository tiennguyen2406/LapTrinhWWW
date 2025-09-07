package iuh.fit.se;

import com.google.gson.Gson;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/users")
public class UserResource {
    @Inject
    private UserService userService;

    private Gson gson = new Gson();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        List<User> users = userService.getAll();
        return Response.ok(gson.toJson(users)).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") int id) {
        return userService.getById(id)
                .map(u -> Response.ok(gson.toJson(u)).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(String body) {
        User user = gson.fromJson(body, User.class);
        userService.add(user);
        return Response.status(Response.Status.CREATED)
                .entity(gson.toJson(user))
                .build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") int id, String body) {
        User newUser = gson.fromJson(body, User.class);
        return userService.update(id, newUser)
                .map(u -> Response.ok(gson.toJson(u)).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") int id) {
        boolean removed = userService.delete(id);
        if (removed) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
