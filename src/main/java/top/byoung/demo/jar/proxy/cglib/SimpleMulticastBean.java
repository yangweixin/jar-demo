package top.byoung.demo.jar.proxy.cglib;

/**
 * @description: SimpleMulticastBean
 * @author: Yang Weixin
 * @create: 2020/05/06
 */
public class SimpleMulticastBean implements DelegatationProvider {
    private String value;
    @Override
    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
