package com.todo.appConfig;

public class AppInitializer{
	
}

//implements WebApplicationInitializer {
//
//	
//	public void onStartup(ServletContext container) throws ServletException {
//		
//		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//		ctx.register(AppConfig.class);
//		ctx.setServletContext(container);
//		
//		DispatcherServlet dispatcher=new DispatcherServlet(ctx);
//		dispatcher.setThrowExceptionIfNoHandlerFound(true);
//
//		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", dispatcher);
//		servlet.setInitParameter("contextClass", "org.springframework.web.context.support.AnnotationConfigWebApplicationContext");
//		servlet.setLoadOnStartup(1);
//		servlet.addMapping("/");
//		
//		EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);
//		 
//        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//        characterEncodingFilter.setEncoding("UTF-8");
//        characterEncodingFilter.setForceEncoding(true);
// 
//        FilterRegistration.Dynamic characterEncoding = container.addFilter("characterEncoding", characterEncodingFilter);
//        characterEncoding.addMappingForUrlPatterns(dispatcherTypes, true, "/*");
//        DelegatingFilterProxy filter = new DelegatingFilterProxy("springSecurityFilterChain");
//        filter.setContextAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcher");
//        container.addFilter("springSecurityFilterChain", filter).addMappingForUrlPatterns(null, true, "/*");
//        
//        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
//        rootContext.register(AppConfig.class);
//        container.addListener(new ContextLoaderListener(rootContext));
//       
//	}
//
//}
