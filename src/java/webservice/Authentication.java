/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import businesslayer.businesslogic.PhoneofuserDelegation;
import businesslayer.businesslogic.UsersDelegation;
import businesslayer.bussiness.InsertingClass;
import businesslayer.bussiness.ReturnList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
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
import pojos.Phoneofuser;
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
    public Response register(MultivaluedMap<String,String> val) throws Exception {
        
         Skilltable skl=new Skilltable();
        skl.setSkillName("انتريهاتfslndlsug");
        InsertingClass.insertSkill(skl);
        Skilltable skl1=new Skilltable();
        skl1.setSkillName("انتريهاتnvxhyu");
        InsertingClass.insertSkill(skl1);
        ReturnList r=new ReturnList();
        UsersDelegation d=new UsersDelegation();
        PhoneofuserDelegation dd=new PhoneofuserDelegation();
        Users s= new Users();
        String userEmail = val.getFirst("userEmail");
        s.setUserEmail(userEmail);
        String userImageUrl= val.getFirst("userImageURL");
        s.setUserImageUrl(userImageUrl);
        String password= val.getFirst("password");
        s.setPassword(password);
        boolean gender = Boolean.parseBoolean(val.getFirst("gender"));
        s.setGender(gender);
        String userName = val.getFirst("userName");
        s.setUserName(userName);
        int ped = Integer.parseInt(val.getFirst("ped"));
        s.setPed(ped);
        String country = val.getFirst("country");
        s.setCountry(country);
        String governorate= val.getFirst("governorate");
        s.setGovernorate(governorate);
        String city = val.getFirst("ciry");
        s.setCity(city);
        String street =val.getFirst("street");
        s.setStreet(street);
        String summery=val.getFirst("summery");
        s.setSummery(summery);
        String profissionalTitle =val.getFirst("Title");
        s.setProfessinalTiltle(profissionalTitle);
        String identifire=val.getFirst("identifire");
        s.setIdentefire(identifire);
        /////////////////////////////////////////////////////////////////mobiles
        String mobile =val.getFirst("mobiles");
        List<String> mobiles = Arrays.asList(mobile.split(","));
        List<Phoneofuser> ph1= r.returnMobiles(mobiles);
        ////////////////////////////////////////////////////////////////phones
        String phone =val.getFirst("phones");
        List<String> phones= Arrays.asList(phone.split(","));
        List<Phoneofuser> ph2= r.returnPhones1(phones);
        /////////////////////////////////////////////////////////all phones of user
        List<Phoneofuser> ph3= r.returnPhones1(ph1,ph2);
        ///////////////////////////////////////////////////////////////Skills
        String Skills =val.getFirst("skill");
        List<String> sk = Arrays.asList((Skills.split(",")));
        List<Integer>  ss=r.returnSkills(sk);
        List<Skilltable> st=r.returnSkillsAll(ss);
        Set sss =new HashSet(st);
     
        for(int i=0;i<st.size();i++){
             s.getSkilltables().add(st.get(i));
             d.delegateInsert(s);    
             System.out.println(st.get(i).getSkillId());
       }
        System.out.println(s.getSkilltables());
        
        ////////////////////////////////////////////////////////////////////////
        
         for(int i=0;i<ph3.size();i++){
          ph3.get(i).setUsers(s);
          dd.delegateInsert(ph3.get(i));
        }
         
        System.out.println(userEmail);
        String output = "The input you sent is :" + userEmail;
        System.out.println(output);
        JSONObject outputJsonObj1 = new JSONObject();
        outputJsonObj1.put("phones", phones);
         outputJsonObj1.put("skill", st);
        outputJsonObj1.put("mobiles", mobiles);
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
  

}
