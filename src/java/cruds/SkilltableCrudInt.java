/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import pojos.Skilltable;

/**
 *
 * @author hassan
 */
public interface SkilltableCrudInt {

    public void insert(Skilltable s);

    public Skilltable select(Integer id);

    public void update(Integer id, Skilltable s);

    public void delete(Integer id);

}
