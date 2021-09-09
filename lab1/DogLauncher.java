public class DogLauncher {
    public static void main(String[] args) {
        Dog d = new Dog(5);     // declaration and instantiation

        Dog d2 = new Dog(30);

        Dog bigger = Dog.maxDog(d, d2); // 使用类名直接调用static方法
//        Dog bigger = d.maxDog(d2);
        bigger.makeNoise();  // invocation
        System.out.println(Dog.binomen);
//        Dog[] dogs = new Dog[2];    // create an array
//        dogs[0] = new Dog(8);   // create an instance
//        dogs[1] = new Dog(20);
//        dogs[0].makeNoise();
    }
}
