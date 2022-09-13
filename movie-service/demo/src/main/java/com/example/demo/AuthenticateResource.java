package com.example.demo;

import com.example.demo.models.AuthenticateRequest;
import com.example.demo.models.AuthenticateResponse;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthenticateResource {
    @Autowired
   private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @RequestMapping({"/hello"})
    @ResponseBody
    public String hello(){
        return "Hello world";
    }
    @RequestMapping(value = "/authenticate" , method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken (@RequestBody AuthenticateRequest authRequest) throws Exception {
    try {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
    }
    catch (BadCredentialsException e) {
        throw new Exception("Incorrect username or password" , e);
        }
    final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
    final String jwt = jwtTokenUtil.generateToken(userDetails);

    return ResponseEntity.ok(new AuthenticateResponse(jwt));
    }

}
