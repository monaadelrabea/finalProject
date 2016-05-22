/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import businesslayer.businesslogic.PhoneofuserDelegation;
import businesslayer.businesslogic.PhoneofuserDelegationInt;
import businesslayer.businesslogic.UsersDelegation;
import businesslayer.businesslogic.UsersDelegationInt;
import businesslayer.bussiness.InsertingClass;
import java.util.Date;
import pojos.Categorytable;
import pojos.Details;
import pojos.DetailsId;
import pojos.Phoneofuser;
import pojos.Porposa;
import pojos.Projectsforusers;
import pojos.Projectsimages;
import pojos.Skilltable;
import pojos.Tagsofprojects;
import pojos.Tagstable;
import pojos.Users;

/**
 *
 * @author hassan
 */
public class Test {

    public static void main(String[] args) {

         

        Categorytable cat =new Categorytable();
        cat.setCategoryName("الاثاث");
        cat.setImageOfCategoryUrl("mmmm");
        InsertingClass.insertCategory(cat);
 ///////////////////////////////////////////////////////////////
        Skilltable skl=new Skilltable();
        skl.setSkillName("انتريهات");
        InsertingClass.insertSkill(skl);
        Skilltable skl1=new Skilltable();
        skl1.setSkillName("انتريهات");
       
/////////////////////////////////////////////////////////////////
       
        Users u= new Users("monaadelrabea@gmail.com","monaImage","mamaandbaba",true,"monyAdel",1000,"مصر","الغربية","كفر الزيات","java devolper","mona");
        u.getSkilltables().add(skl);
        u.getSkilltables().add(skl1);
        UsersDelegation in=new UsersDelegation();
        in.delegateInsert(u);
        skl1.getUserses().add(u);
       InsertingClass.insertSkill(skl1);
    
        /////////////////////////////////////////////////
        Tagstable tag =new Tagstable();
        tag.setTagDescription("الوان بني");
        tag.setCategorytable(cat);
        InsertingClass.insertTag(tag);
    //////////////////////////////////////////////////////////////
        Projectsforusers P=new Projectsforusers();
        P.setProjectName("mmmmmmmmmmmmmmmmmmmm");
        P.setProjectDescription("nnnnnnnnnn");
        P.setBudget(10000);
        P.setStartDate(new Date());
        P.setProjectDeadLine(new Date());
        P.setCategorytable(cat);
        P.setUsers(u);
        P.getSkilltables().add(skl);
        P.getSkilltables().add(skl1);
        InsertingClass.insertProject(P);
        ///////////////////////////////////////////////////////////////////////
        Projectsimages im =new Projectsimages();
        im.setImageUrl("mmmmm");
        im.setProjectsforusers(P);
        InsertingClass.insertImageForProject(im);
        ////////////////////////////////////////////////////////////
         Tagsofprojects tp=new Tagsofprojects();
          tp.setTagstable(tag);
          tp.setProjectsforusers(P);
          InsertingClass.insertTagsOfProjects(tp);
    ////////////////////////////////////////////////////////////
      Details d=new Details();
     DetailsId s=new DetailsId(1, 19);
      d.setId(s);
     Porposa por= InsertingClass.insertPorposa(1);
     Projectsforusers pp=InsertingClass.selectPro(19);
      d.setPorposa(por);
      d.setProjectsforusers(pp);
      d.setRateForOwner(5);
      d.setRateForSuppliers(10);
      d.setCommentFromOwner("fine");
      d.setCommentFromSuppliers("good");
      d.setStatusOfProjects("running");
      InsertingClass.insertDetatils(d);
}

    }


