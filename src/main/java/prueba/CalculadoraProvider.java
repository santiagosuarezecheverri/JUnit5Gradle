package prueba;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;

public class CalculadoraProvider implements TestTemplateInvocationContextProvider{

	@Override
	public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext context) {
		System.out.println("Stream");
		return Stream.of(invocationContext("apple"), invocationContext("banana"));
	}

	@Override
	public boolean supportsTestTemplate(ExtensionContext context) {
		System.out.println("supportsTestTemplate");
		return true;
	}

	private TestTemplateInvocationContext  invocationContext(String parameter) {
		System.out.println("invocationContext");
		return new TestTemplateInvocationContext() {
			@Override
			public String getDisplayName(int invocationIndex) {
				System.out.println("getDisplayName");
				return parameter;
			}

			@Override
			public List<Extension> getAdditionalExtensions() {
				System.out.println("getAdditionalExtensions");
				return Collections.singletonList(new ParameterResolver() {
					@Override
					public boolean supportsParameter(ParameterContext parameterContext,
							ExtensionContext extensionContext) {
						System.out.println("supportsParameter");
						return parameterContext.getParameter().getType().equals(String.class);
					}

					@Override
					public Object resolveParameter(ParameterContext parameterContext,
							ExtensionContext extensionContext) {
						System.out.println("resolveParameter");
						return parameter;
					}
				});
			}
		};
		
	}
}
