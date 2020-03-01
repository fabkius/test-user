package dao;

import com.nissum.user.dao.UserDaoImpl;
import com.nissum.user.domain.PhonesDto;
import com.nissum.user.domain.UserDto;
import fixtures.Fixtures;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityManager;

import java.io.Serializable;
import java.util.ArrayList;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoTest {

    @InjectMocks
    private UserDaoImpl userDao;

    @Mock
    private EntityManager entityManager;

    @Test
    public void shouldReturnSaveOK(){
        /*UserDaoImpl userDao = Mockito.mock(UserDaoImpl.class);
        EntityManager em = Mockito.mock(EntityManager.class);

        when(em.unwrap(any(Session.class))).thenReturn(session);
        Serializable response = userDao.save(Fixtures.SAVE_OK());
        Assert.assertEquals(response,(Long)1l);*/
    }

    @Test
    public void shouldReturnFindOK(){
        when(entityManager.find(any(),any())).thenReturn(Fixtures.SAVE_OK());
        UserDto response = userDao.findById(1l);
        Assert.assertEquals(response.getEmail(),"mail@mail.com");
        Assert.assertEquals(response.getPhones().size(),1);
        Assert.assertEquals(response.getPassword(),"Awertte1");
    }

    @Test
    public void shouldReturnMailExist(){
       /* Query mockedQuery = mock(Query.class);

        when(entityManager.createQuery(any(String.class))).thenReturn(mockedQuery);
       boolean response = userDao.findByMail("mail@mail.com");*/
    }
}
