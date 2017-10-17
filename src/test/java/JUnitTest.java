import org.junit.Test;

public class JUnitTest {

    @Test
    public void test1(){
        String baseStr = "twc";
        for (int i = 1; i <=3000 ; i++) {
            System.out.println(baseStr+i+","+i);
        }
    }
}
