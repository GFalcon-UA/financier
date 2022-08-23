/*
 *   Copyright 2016-2022 Oleksii V. KHALIKOV
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

/*
 * Client Portal Web API
 * Client Poral Web API
 *
 * OpenAPI spec version: 1.0.0
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package ua.com.gfalcon.financier.ibkr.client.okhttp.api;

import org.junit.Ignore;
import org.junit.Test;

/**
 * API tests for StreamingApi
 */
@Ignore
public class StreamingApiTest {

    private final StreamingApi api = new StreamingApi();


    /**
     * Websocket Endpoint
     * <p>
     * The streaming API is documented under [Streaming WebSocket
     * Data](https://interactivebrokers.github.io/cpwebapi/RealtimeSubscription.html) for details.
     *
     * @throws Exception if the Api call fails
     */
    @Test
    public void wsPostTest() throws Exception {
        api.wsPost();

        // TODO: test validations
    }

}
