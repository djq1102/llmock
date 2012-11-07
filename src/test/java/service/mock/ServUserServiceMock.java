package service.mock;

import org.easymock.EasyMock;
import org.springframework.beans.factory.annotation.Autowired;

import exception.BusiException;

import remote.service.ServeUserService;

public class ServUserServiceMock {

	@Autowired
	private ServeUserService serveUserService;

	public void replaySuccess() {
		String exceptedReturUserInfo = "success";

		// record mock
		EasyMock.expect(serveUserService.getUserInfo()).andReturn(
				exceptedReturUserInfo);

		// replay mock
		EasyMock.replay(serveUserService);
	}

	public void replayReturnFailed() {
		// except gets the user info failed or the user info is not extists
		String exceptedReturUserInfo = "failed";

		// record mock
		EasyMock.expect(serveUserService.getUserInfo()).andReturn(
				exceptedReturUserInfo);

		// replay mock
		EasyMock.replay(serveUserService);
	}

	public void replayThrowException() {
		// record mock
		EasyMock.expect(serveUserService.getUserInfo()).andThrow(
				new BusiException("1001", "network connect failed"));

		// replay mock
		EasyMock.replay(serveUserService);
	}

	public void resetMock() {
		EasyMock.reset(serveUserService);
	}
	
	public void verifyMock(){
		EasyMock.verify(serveUserService);
	}

}
