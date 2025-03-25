package net.bi4vmr.study.lifecycle;

import org.junit.*;

/**
 * JUnit生命周期测试。
 *
 * @author BI4VMR@outlook.com
 * @since 1.0.0
 */
public class LifeCycleTest {

    @BeforeClass
    public static void setupClass() {
        System.out.println("@BeforeClass：在测试类首次加载时被执行");
        // 此处用于创建全局资源，例如：初始化数据库连接。
    }

    @Before
    public void setup() {
        System.out.println("@Before：在每个测试方法之前被执行");
    }

    @After
    public void tearDown() {
        System.out.println("@After：在每个测试方法之后被执行");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("@AfterClass：在测试类中的所有方法执行完毕时被执行");
        // 此处用于释放全局资源，例如：清理数据库连接。
    }

    @Test
    public void testFunction01() {
        System.out.println("@Test：测试方法01");
    }

    @Test
    public void testFunction02() {
        System.out.println("@Test：测试方法02");
    }
}
