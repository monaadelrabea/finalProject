/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer.bussiness;

import cruds.CategoryCrudImplementation;
import cruds.DetailsCrudImplementation;
import cruds.ImagesCrudImplementation;
import cruds.ProjectCrudImplementation;
import cruds.SkillCrudImplementation;
import cruds.TagCrudImplementation;
import cruds.TagsForProjectsImplementation;
import cruds.UserCrud;
import crudsinterface.CategoryCrudInterface;
import crudsinterface.DetailsCrudInterface;
import crudsinterface.ImagesCrudInterface;
import crudsinterface.ProjectCrudInterface;
import crudsinterface.SkillCrudInterface;
import crudsinterface.TagCrudInterface;
import crudsinterface.TagsForProjectsInterface;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pojos.Categorytable;
import pojos.Details;
import pojos.Porposa;
import pojos.Projectsforusers;
import pojos.Projectsimages;
import pojos.Skilltable;
import pojos.Tagsofprojects;
import pojos.Tagstable;
import pojos.Users;
import seesioncreator.SessionCreation;

/**
 *
 * @author m@pc
 */
public class InsertingClass {
 public   static void insertUser(Users u){
   UserCrud  uc= new UserCrud(); 
   uc.InsertUser(u);
 }  
 public   static void insertProject(Projectsforusers p){
     ProjectCrudInterface  uc ;
     uc = new ProjectCrudImplementation();
     uc.insertProject(p);
 }
  public   static void insertCategory(Categorytable c){
     CategoryCrudInterface  uc ;
     uc =  new CategoryCrudImplementation();
     uc.insertCategoty(c);
 }
   public   static void insertTag(Tagstable c){
     TagCrudInterface  uc ;
     uc =  new TagCrudImplementation();
     uc.insertTag(c);
 }
   public   static void insertSkill(Skilltable s){
     SkillCrudInterface  uc ;
     uc =  new SkillCrudImplementation();
     uc.insertSkill(s);
 }
    public   static void insertImageForProject(Projectsimages s){
        ImagesCrudInterface  im;
     im =  new ImagesCrudImplementation();
     im.insertImageProject(s);
 }
     public   static void insertTagsOfProjects(Tagsofprojects tg){
       TagsForProjectsInterface tag;
     tag =  new TagsForProjectsImplementation();
     tag.insertTagsOfProjects(tg);
 }
      public   static void insertDetatils(Details dt){
       DetailsCrudInterface d;
     d =  new DetailsCrudImplementation();
     d.insertDetails(dt);
 }
          public static Porposa  insertPorposa(int id){
     Session se = SessionCreation.getSessionFactory().openSession();
     se.beginTransaction();
    Porposa p=(Porposa) se.get(Porposa.class, id);
    se.getTransaction().commit();
       se.close();
        return p;    
    }
             public static Projectsforusers  selectPro(int id){
          ProjectCrudInterface  uc ;
     uc = new ProjectCrudImplementation();
     Projectsforusers p=uc.selectProject(id);
     return p;
    }
 }

