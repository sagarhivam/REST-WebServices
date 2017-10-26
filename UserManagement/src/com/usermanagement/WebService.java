package com.usermanagement;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;


@WebServlet("/WebService")
public class WebService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Client client;
	private String REST_SERVICE_URL = "http://localhost:8080/UserManagement/rest/UserService/users";	
	private static String SUCCESS_RESULT = "";

	public WebService() {
		this.client = Client.create();
	}
	
	// To get list of all users
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Calling Rest Web Service (GET METHOD)");
		WebResource webresource = client.resource(REST_SERVICE_URL);
		List<User> users = webresource.get(new GenericType<List<User>>(){});
		//setting the content type  
		RequestDispatcher rd= request.getRequestDispatcher("/allusers.jsp");
		request.setAttribute("arrTemp", users);
		rd.forward(request, response);
	}
	
	//To add a new user
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("delete"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			doDelete(request, response, id); // To delete a user
		}
		if(action.equalsIgnoreCase("view"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			doGet(request, response, id); //To view a user
		}
		
		if(action.equalsIgnoreCase("update")){
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String designation = request.getParameter("designation");
			float salary = Float.parseFloat(request.getParameter("salary"));
			doPut(request,response, id, name, designation, salary);	
		}
		else
		{
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String designation = request.getParameter("designation");
		float salary = Float.parseFloat(request.getParameter("salary"));
		System.out.println("Calling Rest Web Service (POST METHOD)");
		
		WebResource webresource = client.resource(REST_SERVICE_URL);
		
		 String input = "id=" +id + "&name=" + name+ "&designation=" + designation+ "&salary=" +salary;
		 
		 
		 ClientResponse response2 = webresource.accept("application/xml")
	                .type("application/xml").post(ClientResponse.class, input);
		 String output = response2.getEntity(String.class);
		 System.out.println(output);
		if(output.equals("SUCCESS_RESULT"))
		{
			System.out.println("User Added Successfully");
			doGet(request,response);

		}
		else
		{
			SUCCESS_RESULT = "There is an error adding the user. User with given id already exists";
			RequestDispatcher rd= request.getRequestDispatcher("error.jsp");
			request.setAttribute("arrTemp", SUCCESS_RESULT);
			rd.forward(request, response);

		}
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse resp, int id, String name, String designation, float salary) throws ServletException, IOException {
		System.out.println("Calling Rest Web Service (PUT METHOD)");
		
		WebResource webresource = client.resource(REST_SERVICE_URL);
		
		 String input = "id=" +id + "&name=" + name+ "&designation=" + designation+ "&salary=" +salary;
		 
		 
		 ClientResponse response2 = webresource.accept("application/xml")
	                .type("application/xml").put(ClientResponse.class, input);
		 String output = response2.getEntity(String.class);
		 System.out.println(output);
		 if(output.equals("SUCCESS_RESULT"))
			{
				System.out.println("User Added Successfully");
				doGet(request,resp);

			}
			else
			{
				SUCCESS_RESULT = "There is an error updating the user. User with the given id does not exist.";
				RequestDispatcher rd= request.getRequestDispatcher("error.jsp");
				request.setAttribute("arrTemp", SUCCESS_RESULT);
				rd.forward(request, resp);

			}
	}

	private void doGet(HttpServletRequest request, HttpServletResponse response, int id) throws ServletException, IOException {
		int id_view = id; 
		System.out.println(id_view);
		System.out.println("Calling Rest Web Service (GET USER METHOD)");
		String new_url = REST_SERVICE_URL +"/"+id_view;
		WebResource webResource=client.resource
				(new_url);
		ClientResponse response2 = 
				webResource.type("application/xml").get(ClientResponse.class);
		User user_id = response2.getEntity(User.class);
		System.out.println(response2.getStatus());
		if(user_id == null)
		{
			SUCCESS_RESULT = "The user with the given id does not exist";
			RequestDispatcher rd= request.getRequestDispatcher("error.jsp");
			request.setAttribute("arrTemp", SUCCESS_RESULT);
			rd.forward(request, response);
		}
		else
		{
			String name = user_id.getName();
			String designation = user_id.getDesignation();
			float salary = user_id.getSalary();
			RequestDispatcher rd= request.getRequestDispatcher("allusers.jsp");
			request.setAttribute("id", id_view);
			request.setAttribute("name", name);
			request.setAttribute("designation", designation);
			request.setAttribute("salary", salary);
			rd.forward(request, response);
			
		}
	}

	protected void doDelete(HttpServletRequest req, HttpServletResponse resp, int id) throws ServletException, IOException {
		int id_delete = id; 
		System.out.println(id_delete);
		System.out.println("Calling Rest Web Service (DELETE METHOD)");
		String new_url = REST_SERVICE_URL +"/"+id_delete;
		WebResource webResource=client.resource
				(new_url);
		ClientResponse response = 
				webResource.type("application/xml").delete(ClientResponse.class);
		 String output = response.getEntity(String.class);
		 System.out.println(output);
					
				
				if(output.equals("SUCCESS_RESULT"))
				{
					System.out.println("User Deleted Successfully");
							doGet(req,resp);

				}
				else
				{
					SUCCESS_RESULT = "There is an error deleting the user.User does not exist.";
					RequestDispatcher rd= req.getRequestDispatcher("error.jsp");
					req.setAttribute("arrTemp", SUCCESS_RESULT);
					rd.forward(req, resp);

				}
				doGet(req,resp);

	}
	
	
	
	
	
	
	
	
}
