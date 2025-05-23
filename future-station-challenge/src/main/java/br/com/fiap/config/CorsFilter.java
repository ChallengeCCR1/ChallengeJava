package br.com.fiap.config;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {

        String origin = requestContext.getHeaderString("Origin");

        // Permitir localhost e domínios do Vercel
        if (origin != null && (
                origin.equals("http://localhost:3000") ||
                        origin.contains(".vercel.app")
        )) {
            responseContext.getHeaders().add("Access-Control-Allow-Origin", origin);
            responseContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
        }

        // Cabeçalhos e métodos permitidos
        responseContext.getHeaders().add("Access-Control-Allow-Headers",
                "origin, content-type, accept, authorization");
        responseContext.getHeaders().add("Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS, HEAD");
    }
}