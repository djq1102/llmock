package remote.service.withmock;

import local.service.UserService;
import local.service.impl.UserServiceImpl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.mock.ServUserServiceMock;

@Configurable(autowire = Autowire.BY_NAME)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class ServeUserServiceTest extends Assert {


	@Autowired
	private UserService userService;
	
	@Autowired
	private ServUserServiceMock servUserServiceMock;
	

	/**
	 * test {@link UserServiceImpl#getUserInfo()} assert gets user info success
	 */
	@Test
	public void testGetUserInfo() {
		
		servUserServiceMock.replaySuccess();
		
		// assert return user info is success
		assertTrue(userService.getUserInfo());
		
		servUserServiceMock.resetMock();
		
//		EasyMock.verify(serveUserService);

	}

	/**
	 * 期望返回失败
	 */
	@Test
	public void testGetUserInfoReturnFailed() {
		servUserServiceMock.replayReturnFailed();

		// assert return user info is failed
		assertFalse(userService.getUserInfo());
		

		servUserServiceMock.resetMock();
	}

	@Test
	public void testGetUserInfoThrowException() {

		servUserServiceMock.replayThrowException();


		// assert return user info is failed
		assertFalse(userService.getUserInfo());
		

		servUserServiceMock.resetMock();
	}

}
