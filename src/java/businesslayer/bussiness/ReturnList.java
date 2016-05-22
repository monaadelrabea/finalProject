/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer.bussiness;

import businesslayer.businesslogic.SkilltableDelegation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import pojos.Phoneofuser;
import pojos.Skilltable;

/**
 *
 * @author m@pc
 */
public class ReturnList {
    public List<Phoneofuser> returnMobiles(List<String> ph){
         List<Phoneofuser> phones=new ArrayList<>();
         for(int i=0;i<ph.size();i++){
           Phoneofuser p=new Phoneofuser();
           p.setPhoneNumber(ph.get(i));
             p.setPhoneType("mobiles");
           phones.add(p);
         }
     return phones;
    }
     public List<Phoneofuser> returnPhones1(List<String> ph){
         List<Phoneofuser> phones=new ArrayList<>();
         for(int i=0;i<ph.size();i++){
           Phoneofuser p=new Phoneofuser();
           p.setPhoneNumber(ph.get(i));
           p.setPhoneType("phones");
           phones.add(p);
         }
     return phones;
    }
     
     public List<Phoneofuser> returnPhones1(List<Phoneofuser> ph1,List<Phoneofuser> ph2){
         List<Phoneofuser> phones=new ArrayList<>();
         for(int i=0;i<ph1.size();i++){
           Phoneofuser p=new Phoneofuser();
           phones.add(ph1.get(i));
         }
         for(int i=0;i<ph2.size();i++){
           Phoneofuser p=new Phoneofuser();
          phones.add(ph2.get(i));
         }
     return phones;
    }
     
       public List<Integer> returnSkills(List<String> sk){
         List<Integer> skills=new ArrayList<>();
         for(int i=0;i<sk.size();i++){
          int x= Integer.parseInt(sk.get(i));
           skills.add(x);
         }
     return skills;
    }
    
       
        public List<Skilltable> returnSkillsAll(List<Integer> skk){
         SkilltableDelegation d=new SkilltableDelegation();
         List<Skilltable> skills=new ArrayList<>();
         for(int i=0;i<skk.size();i++){
         Skilltable st =d.delegateSelect(skk.get(i));
          skills.add(st);
         }
     return skills;
    }
    
    }
    
