/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import businesslayer.businesslogic.SkilltableDelegation;
import businesslayer.businesslogic.UsersDelegation;
import businesslayer.businesslogicinterface.SkilltableDelegationInt;
import businesslayer.businesslogicinterface.UsersDelegationInt;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONObject;
import pojos.Skilltable;
import pojos.Users;

/**
 *
 * @author hassan
 */
@Path("/authentication")
public class Authentication {

    @POST
    @Path("/register")
    public Response register(MultivaluedMap<String, String> val) throws Exception {

        UsersDelegation ud = new UsersDelegation();
        String userEmail = val.getFirst("userEmail");;
        String userImageUrl = val.getFirst("userImage");
        String password = val.getFirst("password");
        boolean gender = Boolean.parseBoolean(val.getFirst("gender"));
        String userName = val.getFirst("userName");
        int ped = Integer.parseInt("0");
        String country = val.getFirst("country");
        String governorate = val.getFirst("governorate");
        String city = val.getFirst("ciry");
        String street = val.getFirst("street");
        String summery = val.getFirst("summery");
        String profissionalTitle = val.getFirst("Title");
        String identifire = val.getFirst("identifire");
        /////////////////////////////////////////////////////////////////mobiles
        String mobile = val.getFirst("mobiles");
        //////////////////////////////////////////////////////////////////phones
        String phones = val.getFirst("phones");
        //////////////////////////////////////////////////////////////////Skills
        String Skills = val.getFirst("skill");

        Boolean output = ud.delegateInsert(userEmail, userImageUrl, password, gender, userName, ped, country, governorate, city, street, summery, profissionalTitle, identifire, mobile, phones, Skills);
        JSONObject outputJsonObj1 = new JSONObject();
           System.out.println(output);
        if (output == true) {
            System.out.println(output);
            outputJsonObj1.put("output", "tureInsert");
        } else {
            outputJsonObj1.put("output", "there is some empty data please inter it");
        }
        return Response.status(200).entity(outputJsonObj1).build();
    }

    
    @POST
    @Path("/login")
    public Response login(MultivaluedMap<String, String> val) throws Exception {

        UsersDelegationInt usersDelegationInt = new UsersDelegation();
        Users u = usersDelegationInt.delegateSelectEP(val.getFirst("email"), val.getFirst("pass"));
        String code = "1";
        String message = "true";
        Gson g = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
        Map<String, Object> map = new HashMap();
        map.put("code", code);
        map.put("message", message);
        map.put("user", u);

        return Response.status(200).entity(g.toJson(map)).build();
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

    @GET
    @Path("/query")
    public Response getUsers(
            @QueryParam("from") int from,
            @QueryParam("to") int to,
            @QueryParam("orderBy") List<String> orderBy) {

        return Response
                .status(200)
                .entity("getUsers is called, from : " + from + ", to : " + to
                        + ", orderBy" + orderBy.toString()).build();

    }

    @GET
    @Path("/querySkill")
    public Response getSkills() {
        Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        SkilltableDelegationInt s = new SkilltableDelegation();
        Skilltable n = s.delegateSelect(92);
        String out = g.toJson(n);
        return Response
                .status(200)
                .entity("getUsers is called, from :" + out).build();

    }

}
