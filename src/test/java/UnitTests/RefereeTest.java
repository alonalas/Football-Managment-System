package UnitTests;

import DataLayer.IDataManager;
import LogicLayer.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RefereeTest  {


    private IDataManager dm;
    private User user;

    @Before
    public void init(){
        dm =  DataComp.getInstance();
        user = new User("@","d","d");
    }
    @Test
    public void makeUserReferee() {
        assertTrue(Referee.MakeUserReferee(user , "good","kobi"));
        assertFalse(Referee.MakeUserReferee(user , "good","kobi"));
        assertTrue(user.getRoles().size()==1) ;
    }

    @Test
    public void removeUserReferee() {
        Referee.MakeUserReferee(user , "good","kobi");
        Referee referee =  user.ifUserRoleIncludeReferee() ;
        assertTrue(Referee.RemoveUserReferee(referee));
        assertTrue(user.getRoles().size()==0) ;
        assertFalse(Referee.RemoveUserReferee(referee));
        assertTrue(user.getRoles().size()==0) ;
    }
}