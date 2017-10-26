
package com.usermanagement;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.servlet.http.HttpServletResponse;

@Path("/UserService")
public class UserService {

	UserDao userDao = new UserDao();

	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getUsers() {
		return userDao.getAllUsers();
	}

	@GET
	@Path("/users/{userid}")
	@Produces(MediaType.APPLICATION_XML)
	public User getUser(@PathParam("userid") int userid) {
		System.out.println("Calling method get user with id");
		return userDao.getUser(userid);
	}

	@POST
	@Path("/users")
	@Produces(MediaType.APPLICATION_XML)
	public String createUser(@FormParam("id") int id, @FormParam("name") String name,
			@FormParam("designation") String designation, @FormParam("salary") float salary,
			@Context HttpServletResponse servletResponse) throws IOException {
		User user = new User(id, name, designation, salary);
		int result = userDao.addUser(user);
		System.out.println("Post Method called");
		if (result == 1) {
			return "SUCCESS_RESULT";
		}
		return "FAILURE_RESULT";
	}

	@DELETE
	@Path("/users/{userid}")
	@Produces(MediaType.APPLICATION_XML)
	public String deleteUser(@PathParam("userid") int userid) {
		System.out.println("Calling delete method rest api");
		int result = userDao.deleteUser(userid);
		if (result == 1) {
			return "SUCCESS_RESULT";
		}
		return "FAILURE_RESULT";
	}

	@PUT
	@Path("/users")
	@Produces(MediaType.APPLICATION_XML)
	public String updateUser(@FormParam("id") int id, @FormParam("name") String name,
			@FormParam("designation") String designation, @FormParam("salary") float salary,
			@Context HttpServletResponse servletResponse) throws IOException  {
		User user = new User(id, name, designation, salary);
		int result = userDao.updateUser(user);
		if (result == 1) {
			return "SUCCESS_RESULT";
		}
		return "FAILURE_RESULT";
	}
}
