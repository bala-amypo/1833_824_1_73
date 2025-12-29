
// // package com.example.demo.config;

// // import io.swagger.v3.oas.models.OpenAPI;
// // import io.swagger.v3.oas.models.Components;
// // import io.swagger.v3.oas.models.servers.Server;
// // import io.swagger.v3.oas.models.security.SecurityRequirement;
// // import io.swagger.v3.oas.models.security.SecurityScheme;
// // import org.springframework.context.annotation.Bean;
// // import org.springframework.context.annotation.Configuration;

// // import java.util.List;

// // @Configuration
// // public class SwaggerConfig {

// //     @Bean
// //     public OpenAPI customOpenAPI() {

// //         final String securitySchemeName = "BearerAuth";

// //         return new OpenAPI()
                
// //                 .servers(List.of(
// //                         new Server().url("https://9037.32procr.amypo.ai/")
// //                 ))

                
// //                 .addSecurityItem(
// //                         new SecurityRequirement().addList(securitySchemeName)
// //                 )

                
// //                 .components(
// //                         new Components()
// //                                 .addSecuritySchemes(
// //                                         securitySchemeName,
// //                                         new SecurityScheme()
// //                                                 .name(securitySchemeName)
// //                                                 .type(SecurityScheme.Type.HTTP)
// //                                                 .scheme("bearer")
// //                                                 .bearerFormat("JWT")
// //                                 )
// //                 );
// //     }
// // }
// package com.example.demo.config;

// import io.swagger.v3.oas.models.OpenAPI;
// import io.swagger.v3.oas.models.Components;
// import io.swagger.v3.oas.models.security.SecurityScheme;
// import io.swagger.v3.oas.models.security.SecurityRequirement;
// import io.swagger.v3.oas.models.servers.Server;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import java.util.List;

// @Configuration
// public class SwaggerConfig {

//     @Bean
//     public OpenAPI customOpenAPI() {

//         SecurityScheme jwtScheme = new SecurityScheme()
//                 .type(SecurityScheme.Type.HTTP)
//                 .scheme("bearer")
//                 .bearerFormat("JWT");

//         return new OpenAPI()
//                 .servers(List.of(
//                         new Server().url("https://9037.32procr.amypo.ai")
//                 ))
//                 .components(new Components().addSecuritySchemes("BearerAuth", jwtScheme))
//                 .addSecurityItem(new SecurityRequirement().addList("BearerAuth"));
//     }
// }
package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    private static final String SECURITY_SCHEME_NAME = "bearerAuth";

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
                .components(new Components()
                        .addSecuritySchemes(SECURITY_SCHEME_NAME,
                                new SecurityScheme()
                                        .name(SECURITY_SCHEME_NAME)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        )
                )
                .servers(List.of(
                        new Server().url("https://9176.pro604cr.amypo.ai/")
                ));
    }
}
