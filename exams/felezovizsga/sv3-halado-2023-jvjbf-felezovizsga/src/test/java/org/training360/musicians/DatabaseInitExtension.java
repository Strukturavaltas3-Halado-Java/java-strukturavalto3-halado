package org.training360.musicians;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.extension.*;

public class DatabaseInitExtension implements AfterEachCallback, ParameterResolver {

    EntityManagerFactory factory;

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        factory.close();
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType()
                .equals(EntityManagerFactory.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        factory = Persistence.createEntityManagerFactory("pu");
        return factory;
    }
}
