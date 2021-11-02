public class HOFdemo {

    public static int do_twice(IntUnaryFunction f, int x){
        return f.apply(f.apply(x));
    }

    public static void main(String[] args) {
        TenX tenx = new TenX();
        int o = do_twice(tenx, 2);
        System.out.println(o);
    }
}
