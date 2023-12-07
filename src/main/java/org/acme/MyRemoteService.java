package org.acme;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import java.util.Arrays;
import java.util.HashSet;
import jakarta.annotation.security.PermitAll;
import jakarta.enterprise.inject.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.Set;
import org.eclipse.microprofile.jwt.Claims;
import io.smallrye.jwt.build.Jwt;
import jakarta.annotation.security.RolesAllowed;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import jakarta.inject.Inject;



@Path("/jwt")
public class MyRemoteService {

@GET
@PermitAll
public String generator() {
    return Jwt.issuer("http://localhost:8081")
            .upn("rafael@developer.io")
            .groups(new HashSet<>(Arrays.asList("User", "Admin")))
            .claim(Claims.full_name, "Rafael Rodrigues")
            .sign();
        }

}
