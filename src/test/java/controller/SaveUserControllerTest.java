package controller;

import com.nissum.user.controller.SaveUserController;
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

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SaveUserControllerTest {

    @InjectMocks
    private SaveUserController saveUserController;

    @Mock
    private UserService userService;

    @Test
    public void shouldReturnSaveUserOk(){
        when(userService.save(any(UserDto.class))).thenReturn(Fixtures.SAVE_RS_OK());
        UserRsDto response = saveUserController.addUser(Fixtures.SAVE_OK());
        Assert.assertEquals(response.getId(),(Long)1l);
        Assert.assertEquals(response.getCreated(),"11-01-2020 11:22:11");
        Assert.assertEquals(response.getModified(),"11-01-2020 11:22:11");
        Assert.assertNotNull(response.getToken());
    }

    @Test(expected = EntityExistsException.class)
    public void shouldReturnSaveUserBadMail(){
        when(userService.save(any(UserDto.class))).thenThrow(EntityExistsException.class);
        saveUserController.addUser(Fixtures.SAVE_BADMAIL());
    }

    @Test(expected = EntityExistsException.class)
    public void shouldReturnSaveUserBadPassword(){
        when(userService.save(any(UserDto.class))).thenThrow(EntityExistsException.class);
        saveUserController.addUser(Fixtures.SAVE_BADPASSWORD());
    }

    @Test
    public void shouldReturnFindOK(){
        when(userService.getUser(any(Long.class))).thenReturn(Fixtures.SAVE_OK());
        UserDto response = saveUserController.findUser(1L);
        Assert.assertEquals(response.getEmail(),"mail@mail.com");
        Assert.assertEquals(response.getPassword(),"Awertte1");
        Assert.assertEquals(response.getPhones().get(0).getCitycode(),"32");

    }
}
