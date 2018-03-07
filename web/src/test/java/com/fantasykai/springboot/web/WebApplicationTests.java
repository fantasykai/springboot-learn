package com.fantasykai.springboot.web;

import com.fantasykai.springboot.web.web.WebController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * The type Web application tests.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WebApplicationTests {

    private MockMvc mockMvc;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new WebController()).build();
    }

    /**
     * Gets user.
     *
     * @throws Exception the exception
     */
    @Test
    public void getUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/oneUser")).andDo(MockMvcResultHandlers.print());
    }

    /**
     * Gets users.
     *
     * @throws Exception the exception
     */
    @Test
    public void getUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users")).andDo(MockMvcResultHandlers.print());
    }


    /**
     * Gets user by name.
     *
     * @throws Exception the exception
     */
    @Test
    public void getUserByName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/fantasy")).andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void saveUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .param("name", "")
                .param("age", "200")
                .param("sex", "3")).andDo(MockMvcResultHandlers.print());

    }

}
