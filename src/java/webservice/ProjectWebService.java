/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import businesslayer.businesslogic.ProjectDelegation;
import businesslayer.businesslogicinterface.ProjectDelegationInt;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONObject;
import pojos.Category;
import pojos.Projectsforusers;

/**
 *
 * @author hassan
 */
@Path("/project")
public class ProjectWebService {

    @POST
    @Path("/Project")
    public Response selectUser(MultivaluedMap<String, String> val) throws Exception {

        ProjectDelegationInt delegationInt = new ProjectDelegation();
        boolean flag = delegationInt.delegateInsert(val.getFirst("projectName"), val.getFirst("projectDescription"), Integer.parseInt(val.getFirst("budget")), Date.valueOf(val.getFirst("startDate")), Date.valueOf(val.getFirst("projectDeadLine")), val.getFirst("projectsimageses"), val.getFirst("skilltables"), val.getFirst("tagsofprojectses"), Integer.parseInt(val.getFirst("userId")), Integer.parseInt(val.getFirst("categoryId")));
        JSONObject outputJsonObj = new JSONObject();
        if (flag) {

            outputJsonObj.put("output", "tureInsert");

        } else {

            outputJsonObj.put("output", "there is some empty data please inter it");

        }

        return Response.status(200).entity(outputJsonObj).build();
    }
     @GET
    @Path("/getLastProject")
    public Response selectLastUser() throws Exception {
        System.out.println("in web service mona");
        ProjectDelegationInt delegationInt = new ProjectDelegation();
        ArrayList<Projectsforusers> categories=delegationInt.selectLastInterd();
      Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();      
     String out=g.toJson(categories);
      Map<String, Object> map =new HashMap();
      map.put("satatus", true);
      map.put("projects", categories);    
     System.out.println(out);
        return Response.status(200).entity(g.toJson(map)).build();
    }
}
