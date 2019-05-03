//package top.bertz;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
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
//import top.bertz.calculator.Calculate;
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
//public class CalculatorApplicationTests {
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
//    @Test
//    public void shouldReturn200WhenSendingRequestToManagementInfo() throws Exception {
//        @SuppressWarnings("rawtypes")
//        ResponseEntity<Map> entity = this.testRestTemplate.getForEntity(
//                "http://localhost:" + this.mgt + "/actuator/info", Map.class);
//
//        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
//    }
//
//    @Test
//    public void shouldReturn200WhenSendingRequestToManagementHealth() throws Exception {
//        @SuppressWarnings("rawtypes")
//        ResponseEntity<Map> entity = this.testRestTemplate.getForEntity(
//                "http://localhost:" + this.mgt + "/actuator/health", Map.class);
//
//        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
//    }
//
//
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    private Calculate cal=new Calculate();
//
//    @Test
//    public void add() {
//        String input="3+5;\r\n";
//        String res="";
//        try{
//            res=cal.cal(input);
//        }catch (Exception e){
//            System.out.println(e);
//        }
//
//        assertEquals("8.0",res);
//    }
//
//    @Test
//    public void divide() {
//        String input="5/2;\r\n";
//        String res="";
//        try{
//            res=cal.cal(input);
//        }catch (Exception e){
//            System.out.println(e);
//        }
//
//        assertEquals("2.5",res);
//    }
//
//    @Test
//    public void mul() {
//        String input="3*5;\r\n";
//        String res="";
//        try{
//            res=cal.cal(input);
//        }catch (Exception e){
//            System.out.println(e);
//        }
//
//        assertEquals("15.0",res);
//    }
//
//    @Test
//    public void minus() {
//        String input="5-8;\r\n";
//        String res="";
//        try{
//            res=cal.cal(input);
//        }catch (Exception e){
//            System.out.println(e);
//        }
//
//        assertEquals("-3.0",res);
//    }
//
//    @Test
//    public void mod() {
//        String input="5%8;\r\n";
//        String res="";
//        try{
//            res=cal.cal(input);
//        }catch (Exception e){
//            System.out.println(e);
//        }
//
//        assertEquals("5.0",res);
//    }
//
//    @Test
//    public void factorial() {
//        String input="3!;\r\n";
//        String res="";
//        try{
//            res=cal.cal(input);
//        }catch (Exception e){
//            System.out.println(e);
//        }
//
//        assertEquals("6.0",res);
//    }
//
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
//    @Test
//    public void accessSecuredResourceUnauthenticatedThenRedirectsToLogin() throws Exception {
//        mockMvc.perform(get("/calculator"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrlPattern("**/login"));
//    }
//
//    @Test
//    @WithMockUser
//    public void accessSecuredResourceAuthenticatedThenOk() throws Exception {
//        mockMvc.perform(get("/calculator"))
//                .andExpect(status().isOk());
//    }
//
//
//
//
//}
