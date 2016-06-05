/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import javax.ws.rs.Path;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 *
 * @author m@pc
 */
@Path("/ask")
public class QuestionsWebService {
 public Response askAndReply(MultivaluedMap<String, String> val) {
     
     
     
   return Response.status(200).entity("mona").build();   
 }  
}
