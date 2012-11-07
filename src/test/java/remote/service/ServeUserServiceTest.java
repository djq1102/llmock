package remote.service;

import local.service.UserService;
import local.service.impl.UserServiceImpl;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import exception.BusiException;

@Configurable(autowire = Autowire.BY_NAME)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class ServeUserServiceTest extends Assert {

	@Autowired
	private ServeUserService serveUserService;

	@Autowired
	private UserService userService;
	
	@Before
	public void before(){
		EasyMock.reset(serveUserService);
	}

	/**
	 * test {@link UserServiceImpl#getUserInfo()} assert gets user info success
	 */
	@Test
	public void testGetUserInfo() {
		String exceptedReturUserInfo = "success";

		// record mock
		EasyMock.expect(serveUserService.getUserInfo()).andReturn(
				exceptedReturUserInfo);

		// replay mock
		EasyMock.replay(serveUserService);
		

		// assert return user info is success
		assertTrue(userService.getUserInfo());
		
		EasyMock.verify(serveUserService);

	}

	/**
	 * 期望返回失败
	 */
	@Test
	public void testGetUserInfoReturnFailed() {
		// except gets the user info failed or the user info is not extists
		String exceptedReturUserInfo = "failed";

		// record mock
		EasyMock.expect(serveUserService.getUserInfo()).andReturn(
				exceptedReturUserInfo);

		// replay mock
		EasyMock.replay(serveUserService);

		// assert return user info is failed
		assertFalse(userService.getUserInfo());
	}

	@Test
	public void testGetUserInfoThrowException() {

		// record mock
		EasyMock.expect(serveUserService.getUserInfo()).andThrow(new BusiException("1001", "network connect failed"));

		// replay mock
		EasyMock.replay(serveUserService);


		// assert return user info is failed
		assertFalse(userService.getUserInfo());
	}

}
