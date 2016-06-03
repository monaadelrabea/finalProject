/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import businesslayer.businesslogic.CategoryDelegation;
import businesslayer.businesslogic.UsersDelegation;
import businesslayer.businesslogicinterface.CategoryDelegationInt;
import businesslayer.businesslogicinterface.UsersDelegationInt;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import pojos.Users;

/**
 *
 * @author m@pc
 */
@Path("/user")
public class UserWebService {

    @GET
    @Path("/getUser")
    public Response selectUser(@QueryParam("userId") int userId) throws Exception {
        String message = "";
        UsersDelegationInt user = new UsersDelegation();
        Users u = user.delegateSelect(userId);
        Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        //String out=g.toJson(user);
        Map<String, Object> map = new HashMap();
        map.put("satatus", true);
        map.put("categories", u);
        //System.out.println(out);
        return Response.status(200).entity(g.toJson(map)).build();
    }
}
