package interfaces;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

import entities.Account;
import managers.*;

@Path("/sar")
public class REST_controller {
    private AccountBoundaryInterface account_boundary_interface = new AccountManager();
    private RideBoundaryInterface ride_boundary_interface = new RideManager();
    private ReportBoundaryInterface report_boundary_interface = new ReportManager();

    private Response generateValidationErrorResponse(String detail, String instance) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.put("type", "http://cs.iit.edu/~virgil/cs445/project/api/problems/data-validation");
        jsonObject.put("title", "Your request data didn't pass validation");
        jsonObject.put("detail", detail);
        jsonObject.put("status", 400);
        jsonObject.put("instance", instance);
        
    }
    
    @GET
    @Produces("text/plain")
    public Response test() {
        // Test if the server is working properly
        String s = "Working properly";
        return Response.status(Response.Status.OK).entity(s).build();
    }
    
    @Path("/accounts")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAccount(@Context UriInfo uriInfo, String json) {
    	JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
    	String first_name = jsonObject.get("first_name").toString();
    	String last_name = jsonObject.get("last_name").toString();
    	String phone = jsonObject.get("phone").toString();
    	String picture = jsonObject.get("picture").toString();
    	boolean is_active = Boolean.parseBoolean(jsonObject.get("is_active").toString());
    	
    	int aid = account_boundary_interface.createAccount(first_name, last_name, phone, picture, is_active);
    	
    	//Prepare Response
    	Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson(aid);
        
        // Build the URI for the "Location:" header
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(aid));
        
        // The response includes header and body data
        return Response.created(builder.build()).entity(s).build();	
            
    }
    

}
