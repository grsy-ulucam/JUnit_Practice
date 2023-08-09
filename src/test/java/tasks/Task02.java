package tasks;

import org.junit.*;

public class Task02 {

    @Test
    public  void  test01(){
    System.out.println("test1 runs");
}
    @Test
    public  void  test02(){
        System.out.println("test2 runs");
    }

    @Test
    public  void  test03(){
        System.out.println("test3 runs");
    }
    @Test
    @Ignore
    public  void  test04(){
        System.out.println("test4 develop");
    }
   @Before
    public  void beforeEach(){
       System.out.println("before method it runs");
   }
   @After
    public  void  afterEach(){
       System.out.println("after method it runs");
   }
   @BeforeClass
    public  static  void  beforeAll(){
       System.out.println("before all methods it runs");
   }
   @AfterClass
    public  static  void  afterAll(){
       System.out.println("after all methods it runs");
   }
}
