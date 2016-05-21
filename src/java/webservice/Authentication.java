/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author hassan
 */
@Path("/authentication")
public class Authentication {

    @POST
    @Path("/register")
    public Response register(MultivaluedMap<String,String> val) throws Exception {

        String input = val.getFirst("input");
        System.out.println(input);
        String output = "The input you sent is :" + input;
        System.out.println(output);
        JSONObject outputJsonObj1 = new JSONObject();
        outputJsonObj1.put("output", output);

        return Response.status(200).entity(outputJsonObj1).build();
    }

    @GET
    @Path("/test")
    public Response test(@QueryParam("name") String name) throws Exception {

        String input = name;
        String output = "The input you sent is :" + input;
        System.out.println(output);
        JSONObject outputJsonObj = new JSONObject();
        outputJsonObj.put("output", output);

        return Response.status(200).entity(outputJsonObj).build();
    }

}
