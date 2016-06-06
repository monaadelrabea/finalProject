/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudsinterface;

import java.util.ArrayList;
import pojos.Skilltable;

/**
 *
 * @author hassan
 */
public interface SkilltableCrudInterface {

    public boolean insert(Skilltable s);

    public Skilltable select(int id);

    public boolean update(Integer id, Skilltable s);

    public boolean delete(Integer id);

        public ArrayList<Skilltable> selectSkills() ;
}
