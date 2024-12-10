package code.spaghetti;

public interface Helper {
    void help();
}

class ClassA {
    private Helper helper;

    public ClassA(Helper helper) {
        this.helper = helper;
    }

    public void doSomething() {
        helper.help();
    }
}

class ClassB implements Helper {
    @Override
    public void help() {
        System.out.println("Helping ClassA...");
    }

    public static void main(String[] args) {
        ClassB b = new ClassB();
        ClassA a = new ClassA(b);

        a.doSomething();
    }
}