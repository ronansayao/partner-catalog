package com.livelo.catalog.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
	from("timer:hello?period={{timer.period}}").routeId("hello").transform().method("myBean", "saySomething")
		.filter(simple("${body} contains 'foo'")).to("log:foo").end().to("stream:out");
    }

}
