package remote.service.withouspring;

import local.service.impl.UserService2Impl;
import local.service.impl.UserServiceImpl;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

import remote.service.ServeUserService;
import exception.BusiException;

public class ServeUserServiceTest extends Assert {

	private ServeUserService serveUserService;

	private UserService2Impl userService;

	/**
	 * test {@link UserServiceImpl#getUserInfo()} assert gets user info success
	 */
	@Test
	public void testGetUserInfo() {
		String exceptedReturUserInfo = "success";
		// create mock object
		serveUserService = EasyMock.createMock(ServeUserService.class);

		// record mock
		EasyMock.expect(serveUserService.getUserInfo()).andReturn(
				exceptedReturUserInfo);

		// replay mock
		EasyMock.replay(serveUserService);

		// pass mock object to userService
		userService = new UserService2Impl();

		userService.setServeUserService(serveUserService);


		// assert return user info is success
		assertTrue(userService.getUserInfo());

	}

	/**
	 * 
	 */
	@Test
	public void testGetUserInfoReturnFailed() {
		// except gets the user info failed or the user info is not extists
		String exceptedReturUserInfo = "failed";
		// create mock object
		serveUserService = EasyMock.createMock(ServeUserService.class);

		// record mock
		EasyMock.expect(serveUserService.getUserInfo()).andReturn(
				exceptedReturUserInfo);

		// replay mock
		EasyMock.replay(serveUserService);

		// pass mock object to userService
		userService = new UserService2Impl();

		userService.setServeUserService(serveUserService);

		// assert return user info is success
		assertFalse(userService.getUserInfo());
	}

	@Test
	public void testGetUserInfoThrowException() {
		// create mock object
		serveUserService = EasyMock.createMock(ServeUserService.class);

		// record mock
		EasyMock.expect(serveUserService.getUserInfo()).andThrow(new BusiException("1001", "network connect failed"));

		// replay mock
		EasyMock.replay(serveUserService);

		// pass mock object to userService
		userService = new UserService2Impl();

		userService.setServeUserService(serveUserService);

		// assert return user info is success
		assertFalse(userService.getUserInfo());
	}

}
