
class HilfsKlasse_A {
    public HilfsKlasse_A() {
        System.out.print("A");
    }
}

class HilfsKlasse_B extends HilfsKlasse_A{
    public HilfsKlasse_B() {
        System.out.print("B");
    }
}

class Generics1 extends HilfsKlasse_B {
    public static void main(String[] args) {
        HilfsKlasse_A b = new HilfsKlasse_B();
    }
}