//package top.bertz;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
////import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.FormLoginRequestBuilder;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.assertj.core.api.BDDAssertions.then;
//import static org.junit.Assert.*;
//
//import java.io.*;
//import java.util.Map;
//
//import org.junit.*;
//
//
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
//import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
//import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
//@TestPropertySource(properties = {"management.port=0"})
//public class GatewayApplicationTests {
//
//    @LocalServerPort
//    private int port;
//
//    @Value("${local.management.port}")
//    private int mgt;
//
//    @Autowired
//    private TestRestTemplate testRestTemplate;
//
////    @Test
////    public void shouldReturn200WhenSendingRequestToController() throws Exception {
////        @SuppressWarnings("rawtypes")
////        ResponseEntity<Map> entity = this.testRestTemplate.getForEntity(
////                "http://localhost:" + this.port+"/", Map.class);
////
////        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
////    }
//
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void loginWithValidUserThenAuthenticated() throws Exception {
//        FormLoginRequestBuilder login = formLogin()
//                .user("user")
//                .password("password");
//
//        mockMvc.perform(login)
//                .andExpect(authenticated().withUsername("user"));
//    }
//
//    @Test
//    public void loginWithInvalidUserThenUnauthenticated() throws Exception {
//        FormLoginRequestBuilder login = formLogin()
//                .user("invalid")
//                .password("invalidpassword");
//
//        mockMvc.perform(login)
//                .andExpect(unauthenticated());
//    }
//
//    @Test
//    public void accessUnsecuredResourceThenOk() throws Exception {
//        mockMvc.perform(get("/"))
//                .andExpect(status().isOk());
//    }
//
//}
