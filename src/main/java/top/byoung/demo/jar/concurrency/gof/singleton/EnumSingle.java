package top.byoung.demo.jar.concurrency.gof.singleton;

public class EnumSingle {

    private byte[] data = new byte[1024];

    private EnumSingle() {

    }

    private enum EnumHolder {
        INSTANCE;

        private EnumSingle instance;

        EnumHolder() {
            this.instance = new EnumSingle();
        }

        private EnumSingle getInstance () {
            return this.instance;
        }
    }

    public EnumSingle getInstance () {
        return EnumHolder.INSTANCE.getInstance();
    }
}
