package pl.zajavka.api.controller;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//@ActiveProfiles("test")//sam ten profil nie dziala trzeba inaczej to skonfigurować Karol nie pokzał
@WebMvcTest(controllers = HomeController.class)
@AutoConfigureMockMvc(addFilters = false)
@AllArgsConstructor(onConstructor = @__(@Autowired))
class HomeControllerTest {

    private MockMvc mockMvc;

    @Test
    void homePageWorksCorrectly() throws Exception {
        //given, when, then
        mockMvc.perform(MockMvcRequestBuilders.get(HomeController.HOME))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("home"));

    }
}