package entities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import interfaces.*;

@Path("/sar")
public class REST_controller {
    private AccountBoundaryInterface account_boundary_interface = new AccountManager();
    private RatingBoundaryInterface ratng_boundary_interface = new RatingManager();
    private ReportBoundaryInterface report_boundary_interface = new ReportManager();
    private RideBoundaryInterface ride_boundary_interface = new RideManager();
    private RideRequestBoundaryInterface ride_request_boundary_interface = new RideRequestManager();

    
    @Path("/accounts")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAccount(@Context UriInfo uriInfo, String first_name, String last_name, String phone, String picture, boolean is_active) {
    	int aid = account_boundary_interface.createAccount("RIDER", first_name, last_name, phone, picture, is_active);
        Account account = account_boundary_interface.viewAccountDetails(aid);
    	
    	//Prepare Response
        Gson gson = new Gson();
        String s = gson.toJson(account);
        // Build the URI for the "Location:" header
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(aid));

        // The response includes header and body data
        return Response.created(builder.build()).entity(s).build();
    }

}
