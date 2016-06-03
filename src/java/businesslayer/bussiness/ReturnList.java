/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer.bussiness;

import businesslayer.businesslogic.SkilltableDelegation;
import cruds.ImagesPortofolioCrudImplementation;
import cruds.TagCrudImplementation;
import cruds.TagsForProjectsImplementation;
import crudsinterface.ImagesProjectCrudInterface;
import crudsinterface.TagCrudInterface;
import crudsinterface.TagsForProjectsInterface;
import java.util.ArrayList;
import java.util.List;
import pojos.Phoneofuser;
import pojos.Projectsforusers;
import pojos.Projectsimages;
import pojos.Skilltable;
import pojos.Tagsofprojects;

/**
 *
 * @author m@pc
 */
public class ReturnList {
    
    public List<Phoneofuser> returnMobiles(List<String> ph) {
        List<Phoneofuser> phones = new ArrayList<>();
        for (int i = 0; i < ph.size(); i++) {
            Phoneofuser p = new Phoneofuser();
            p.setPhoneNumber(ph.get(i));
            p.setPhoneType("mobiles");
            phones.add(p);
        }
        return phones;
    }
    
    public List<Phoneofuser> returnPhones1(List<String> ph) {
        List<Phoneofuser> phones = new ArrayList<>();
        for (int i = 0; i < ph.size(); i++) {
            Phoneofuser p = new Phoneofuser();
            p.setPhoneNumber(ph.get(i));
            p.setPhoneType("phones");
            phones.add(p);
        }
        return phones;
    }
    
    public List<Phoneofuser> returnPhones1(List<Phoneofuser> ph1, List<Phoneofuser> ph2) {
        List<Phoneofuser> phones = new ArrayList<>();
        for (int i = 0; i < ph1.size(); i++) {
            Phoneofuser p = new Phoneofuser();
            phones.add(ph1.get(i));
        }
        for (int i = 0; i < ph2.size(); i++) {
            Phoneofuser p = new Phoneofuser();
            phones.add(ph2.get(i));
        }
        return phones;
    }
    
    public List<Integer> returnSkills(List<String> sk) {
        List<Integer> skills = new ArrayList<>();
        for (int i = 0; i < sk.size(); i++) {
            int x = Integer.parseInt(sk.get(i));
            skills.add(x);
        }
        return skills;
    }
    
    public List<Skilltable> returnSkillsAll(List<Integer> skk) {
        SkilltableDelegation d = new SkilltableDelegation();
        List<Skilltable> skills = new ArrayList<>();
        for (int i = 0; i < skk.size(); i++) {
            Skilltable st = new Skilltable();
            st = d.delegateSelect(skk.get(i));
            skills.add(st);
        }
        return skills;
    }
    
    public List<Projectsimages> returnImagesAll(List<String> skk) {
        List<Projectsimages> ps = new ArrayList<>();
        for (int i = 0; i < skk.size(); i++) {
            Projectsimages p = new Projectsimages();
            p.setImageUrl(skk.get(i));
            ImagesProjectCrudInterface crudInterface = new ImagesPortofolioCrudImplementation();
            crudInterface.insertImageProject(p);
            ps.add(p);
        }
        return ps;
    }
    
    public List<Tagsofprojects> returnTagsAll(List<String> skk, Projectsforusers projectsforusers) {
        List<Tagsofprojects> ps = new ArrayList<>();
        for (int i = 0; i < skk.size(); i++) {
            Tagsofprojects p = new Tagsofprojects();
            TagCrudInterface crudInterface = new TagCrudImplementation();
            p.setTags(crudInterface.selectTag(skk.get(i)));
            p.setProjectsforusers(projectsforusers);
            TagsForProjectsInterface forProjectsInterface = new TagsForProjectsImplementation();
            forProjectsInterface.insertTagsOfProjects(p);
            ps.add(p);
        }
        return ps;
    }
    
}
