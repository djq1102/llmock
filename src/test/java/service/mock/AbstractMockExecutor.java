package service.mock;

import org.easymock.EasyMock;

public abstract class AbstractMockExecutor<T> {
	protected T mock;

	/**
	 * @param clazz
	 * @return
	 */
	protected T createMock(Class<T> clazz) {
		mock = EasyMock.createMock(clazz);
		return mock;
	}

	public void execute() throws Exception {
		record();
		EasyMock.replay(mock);
		invoke();
		verify();
	}

	/**
	 * 创建mock对象, 并对要mock的方法进行方法录制, 必须在该方法中手动调用{@link #createMock(Class)}方法.<br>
	 * 该方法的一般做法如下:
	 * 
	 * <pre>
	 * createMock(MockClass);
	 * EasyMock.expect(mock.mockMethod(mockArgument...)).andReturn(
	 * 		mockResult);
	 * BeanObject.setter(mock);
	 * </pre>
	 * 
	 * @throws Exception
	 */
	protected abstract void record() throws Exception;

	/**
	 * 调用经过mock之后的执行过程
	 */
	protected abstract void invoke() throws Exception;

	/**
	 * 验证mock是否正确
	 */
	public void verify() {
		EasyMock.verify(mock);
	}
}
