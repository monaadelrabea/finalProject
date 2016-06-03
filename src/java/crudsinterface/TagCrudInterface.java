/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudsinterface;

import java.util.ArrayList;
import pojos.Tags;

/**
 *
 * @author m@pc
 */
public interface TagCrudInterface {

    public ArrayList<Tags> selectTags();

    public Tags selectTag(int id);

    public Tags selectTag(String name);

    public boolean insertTag(Tags t);

    public boolean updateTag(Tags t);

    public boolean deleteTag(int id);

}
