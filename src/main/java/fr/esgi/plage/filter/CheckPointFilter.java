package fr.esgi.plage.filter;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CheckPointFilter implements Filter {
    @Override // surcharge
     public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Passage dans le filtre");
        chain.doFilter(request, response); // next poursuit le chemain de la requette
    }
}
