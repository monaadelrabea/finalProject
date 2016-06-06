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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.apache.commons.codec.binary.Base64;
import org.codehaus.jettison.json.JSONObject;
import pojos.Skilltable;
import pojos.Users;

/**
 *
 * @author hassan
 */
@Path("/authentication")
public class Authentication {

    @GET
    @Path("/getSkills")
    public Response getAllSkills() {
        SkilltableDelegationInt s = new SkilltableDelegation();
        Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().serializeNulls().create();
        ArrayList<Skilltable> skills = s.selectSkills();
        Map<String, Object> map = new HashMap();
        map.put("satatus", true);
        map.put("skills", skills);
        return Response.status(200).entity(g.toJson(map)).build();
    }

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
        Gson g = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        Map<String, Object> map = new HashMap();
        map.put("code", code);
        map.put("message", message);
        map.put("user", u);

        return Response.status(200).entity(g.toJson(map)).build();
    }

    public void postMsg2(MultivaluedMap<String, String> val) {
        String fileName = val.getFirst("fileName") + 2;
        System.out.println("mona");
        String filePath = "C:\\Users\\m@pc\\Documents\\NetBeansProjects\\itiProjectServer\\web\\WEB-INF\\images\\" + fileName;
        try {
            byte[] imageByteArray = decodeImage(val.getFirst("image"));

            // Write a image byte array into file system
            FileOutputStream imageOutFile = new FileOutputStream(filePath);
            imageOutFile.write(imageByteArray);

            imageOutFile.close();

            System.out.println("Image Successfully Manipulated!");
        } catch (FileNotFoundException e) {
            System.out.println("Image not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the Image " + ioe);
        }
    }

    public static byte[] decodeImage(String imageDataString) {
        return Base64.decodeBase64(imageDataString.getBytes());
    }
}
