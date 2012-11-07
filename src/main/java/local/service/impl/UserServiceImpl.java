package local.service.impl;

import local.service.UserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import remote.service.ServeUserService;
import exception.BusiException;

/**
 * 调用外部服务获取用户信息
 * 
 * @author aaa
 * 
 */
public class UserServiceImpl implements UserService {
	

    static Logger logger = Logger.getLogger(UserService2Impl.class);

	@Autowired
	private ServeUserService serveUserService;

	public boolean getUserInfo() {
			try {
				if (serveUserService.getUserInfo().equals("success")) {
					logger.info("get user info success, do some success process");
					
					return true;
				}
			} catch (BusiException e) {
				logger.info("["+e.getRetCode()+":"+e.getRetMsg()+"], do some failed process");
				//do something
			}

		return false;

	}

}
