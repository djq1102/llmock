package mock.util;

import org.easymock.EasyMock;
import org.springframework.beans.factory.FactoryBean;

public class EasyMockFactoryBean<T> implements FactoryBean<T> {
    private Class<T> mockedClass;

    public void setMockedClass(Class<T> mockedClass) {
        this.mockedClass = mockedClass;
    } 

    public T getObject() throws Exception {
        return EasyMock.createMock(mockedClass);
    }

    public Class<T> getObjectType() {
        return mockedClass;
    }

    public boolean isSingleton() {
        return true;
    } 

}