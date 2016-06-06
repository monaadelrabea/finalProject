/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer.businesslogic;

import businesslayer.businesslogicinterface.CategoryDelegationInt;
import businesslayer.businesslogicinterface.ProjectDelegationInt;
import businesslayer.businesslogicinterface.UsersDelegationInt;
import businesslayer.bussiness.ReturnList;
import cruds.ProjectCrudImplementation;
import crudsinterface.ProjectCrudInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pojos.Projectsforusers;
import pojos.Projectsimages;
import pojos.Skilltable;
import pojos.Tagsofprojects;

/**
 *
 * @author m@pc
 */
public class ProjectDelegation implements ProjectDelegationInt {

    @Override
    public boolean delegateInsert(String projectName, String projectDescription, int budget, Date startDate, Date projectDeadLine, String projectsimageses, String skilltables, String tagsofprojectses, int userId, int categoryid) {
        Projectsforusers p = new Projectsforusers();
        p.setProjectName(projectName);
        p.setProjectDescription(projectDescription);
        p.setBudget(budget);
        p.setStartDate(startDate);
        p.setProjectDeadLine(projectDeadLine);
        UsersDelegationInt delegationInt = new UsersDelegation();
        p.setUsers(delegationInt.delegateSelect(userId));
        CategoryDelegationInt categoryDelegationInt = new CategoryDelegation();
        p.setCategory(categoryDelegationInt.delegateSelect(categoryid));
        List<String> skList = Arrays.asList((skilltables.split(",")));
        ReturnList returnList = new ReturnList();
        List<Skilltable> list1 = returnList.returnSkillsAll(returnList.returnSkills(skList));
        Set<Skilltable> set1 = new HashSet<>(list1);
        p.setSkilltables(set1);
        List<String> imgList = Arrays.asList((projectsimageses.split(",")));
        List<Projectsimages> list2 = returnList.returnImagesAll(imgList);
        Set<Projectsimages> set2 = new HashSet<>(list2);
        p.setProjectsimageses(set2);
        List<Tagsofprojects> list = returnList.returnTagsAll(Arrays.asList((tagsofprojectses.split(","))), p);
        Set<Tagsofprojects> set = new HashSet<>(list);
        p.setTagsofprojectses(set);
        ProjectCrudInterface uc;
        uc = new ProjectCrudImplementation();
        uc.insertProject(p);
        return true;
    }

    @Override
    public Projectsforusers delegateSelect(int id) {
        
         ProjectCrudInterface uc;
        uc = new ProjectCrudImplementation();
      return  uc.selectProject(id);
    }

    @Override
    public void delegateUpdate(int id, Projectsforusers p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delegateDelete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Projectsforusers> selectLastInterd() {
          System.out.println("in delegation mona");
        ArrayList<Projectsforusers> projects =new ArrayList<>();
         ProjectCrudInterface pc;
        pc = new ProjectCrudImplementation();
      projects =  pc.selectLastInterd();
        return projects;
    }
    @Override
   public ArrayList<Projectsforusers> selectProjects(int id){
      ArrayList<Projectsforusers> projects =new ArrayList<>();
         ProjectCrudInterface pc;
        pc = new ProjectCrudImplementation();
      projects =  pc.selectProjects(id);
        return projects;   
   }

    @Override
    public ArrayList<Projectsforusers> selectBestProjects() {
 ArrayList<Projectsforusers> projects =new ArrayList<>();
         ProjectCrudInterface pc;
        pc = new ProjectCrudImplementation();
      projects =  pc.selectBestProjects();
        return projects;     }
}
