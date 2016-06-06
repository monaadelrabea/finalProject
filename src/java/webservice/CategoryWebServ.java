/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import businesslayer.businesslogic.CategoryDelegation;
import businesslayer.businesslogicinterface.CategoryDelegationInt;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONObject;
import pojos.Category;

/**
 *
 * @author m@pc
 */
@Path("/categoryURL")

public class CategoryWebServ {

    @GET
    @Path("/insertCategory")
    public Response insertCategory(@QueryParam("categoryName") String categoryName, @QueryParam("imageOfCategoryUrl") String imageOfCategoryUrl) throws Exception {

        String message = "";
        CategoryDelegationInt cat = new CategoryDelegation();
        if (cat.delegateInsert(categoryName, imageOfCategoryUrl)) {
            message = "true";
        } else {
            message = "false";

        }

        JSONObject outputJsonObj1 = new JSONObject();
        outputJsonObj1.put("message", message);

        return Response.status(200).entity(outputJsonObj1).build();
    }

    @GET
    @Path("/getCategories")
    public Response selectCategory() throws Exception {
        String message = "";
        CategoryDelegationInt cat = new CategoryDelegation();
        ArrayList<Category> categories = cat.selectCategorys();
        Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().serializeNulls().create();
        String out = g.toJson(categories);
        Map<String, Object> map = new HashMap();
        map.put("satatus", true);
        map.put("categories", categories);
        System.out.println(out);
        return Response.status(200).entity(g.toJson(map)).build();
    }

}
