/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import businesslayer.businesslogic.DetailsDelegation;
import businesslayer.businesslogicinterface.DetailsDelegationInt;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import pojos.Details;

/**
 *
 * @author hassan
 */
@Path("/details")
public class DetailsWebService {

    @GET
    @Path("/updateComment")
    public Response updateComment(@QueryParam("userId") int userId, @QueryParam("projectId") int projectId, @QueryParam("porposaId") int porposaId, @QueryParam("Comment") String Comment) throws Exception {
        DetailsDelegationInt detailsDelegationInt = new DetailsDelegation();
        Details details = detailsDelegationInt.delegateSetCommint(userId, projectId, porposaId, Comment);
        Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        Map<String, Object> map = new HashMap();
        map.put("satatus", details);
        return Response.status(200).entity(g.toJson(map)).build();
    }
    
    @GET
    @Path("/updateRate")
    public Response updateRate(@QueryParam("userId") int userId, @QueryParam("projectId") int projectId, @QueryParam("porposaId") int porposaId, @QueryParam("rate") int rate) throws Exception {
        DetailsDelegationInt detailsDelegationInt = new DetailsDelegation();
        Details details = detailsDelegationInt.delegateSetRate(userId, projectId, porposaId, rate);
        Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        Map<String, Object> map = new HashMap();
        map.put("satatus", details);
        return Response.status(200).entity(g.toJson(map)).build();
    }

}
