public class Main {

    public static void main(String[] args) {
        Humanoid humanoid1 = new Humanoid();
        humanoid1.setHumanoidType("Lady with high heels");
        humanoid1.walk();

        Humanoid humanoid2 = new Humanoid();
        humanoid2.setHumanoidType("Ninja");
        humanoid2.walk();

        Humanoid humanoid3 = new Humanoid();
        humanoid3.setHumanoidType("Pirate");
        humanoid3.walk();

        Humanoid humanoid4 = new Humanoid();
        humanoid4.setHumanoidType("Robot");
        humanoid4.walk();

        Humanoid humanoid5 = new Humanoid();
        humanoid5.setHumanoidType("Regular human");
        humanoid5.walk();
    }
}
