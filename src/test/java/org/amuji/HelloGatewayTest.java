package org.amuji;

import com.github.dreamhead.moco.Moco;
import com.github.dreamhead.moco.junit.MocoJunitRunner;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloGatewayTest {
    @Rule
    public MocoJunitRunner runner = MocoJunitRunner.jsonRestRunner(1076, Moco.pathResource("contracts/hello.json"));

    @Autowired
    private HelloGateway gateway;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void request_hello_for_someone_should_get_a_sentence() {
        String hello = gateway.getHello("Joy");
        assertThat(hello, equalTo("Joy, how do you do?"));
    }
}