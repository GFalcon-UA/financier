/*
 *   Copyright 2016-2021 Oleksii V. KHALIKOV, PE
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package ua.com.gfalcon.financier.backend.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Tests of {@link PingController}.
 *
 * @author Oleksii Khalikov
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PingController.class)
public class PingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPing() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/ping"))
                .andDo(MockMvcResultHandlers.log())
                .andExpect(MockMvcResultMatchers.status()
                        .isOk());
    }
}