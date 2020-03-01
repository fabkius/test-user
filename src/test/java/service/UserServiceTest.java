package service;

import com.nissum.user.dao.UserDao;
import com.nissum.user.domain.UserDto;
import com.nissum.user.domain.UserRsDto;
import com.nissum.user.service.UserService;
import fixtures.Fixtures;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityExistsException;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserDao userdao;

    @InjectMocks
    private UserService userService;

    @Test
    public void shouldReturnSaveOk(){
        when(userdao.save(any(UserDto.class))).thenReturn(Fixtures.CREA_RS_SAVE_SERIALIZABLE());
        when(userdao.findByMail(anyString())).thenReturn(false);
        UserRsDto response = userService.save(Fixtures.SAVE_OK());
        Assert.assertEquals(response.getId(),(Long)1l);
        Assert.assertEquals(response.getModified(),"01-01-1970 06:30:34");
        Assert.assertEquals(response.getLast_login(),"01-01-1970 06:30:34");
        Assert.assertNull(response.getToken());
    }

    @Test(expected = EntityExistsException.class)
    public void shouldReturnMailRegisterNow(){
        when(userdao.save(any(UserDto.class))).thenReturn(Fixtures.CREA_RS_SAVE_SERIALIZABLE());
        when(userdao.findByMail(anyString())).thenReturn(true);
         userService.save(Fixtures.SAVE_OK());
    }

}
