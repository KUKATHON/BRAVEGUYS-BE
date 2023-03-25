package com.bravebe.bravebe.common;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                title = "SAVEUS API 명세서",
                description = "세이버스 프로젝트 API 명세서입니다.",
                version = "v1")
)
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi stOpenApi() {

        return GroupedOpenApi.builder()
                .group("대시보드 API v1")
                .pathsToMatch("/**")
                .build();
    }
}
