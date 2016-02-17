public class Humanoid {
    private String humanoidType;

    public void walk() {
        if (humanoidType.equals("Lady with high heels")) {
            System.out.println("TOC! TOC! TOC!");
        } else {
            if (humanoidType.equals("Ninja")) {
                System.out.println("...");
            } else {
                if (humanoidType.equals("Pirate")) {
                    System.out.println("Tap, toc, tap, toc.");
                } else {
                    if(humanoidType.equals("Robot")) {
                        System.out.println("Bzz, bang, bzzz, bang");
                    } else {
                        if(humanoidType.equals("Regular human")) {
                            System.out.println("Tap, tap, tap, tap");
                        }
                    }
                }
            }
        }
    }

    public String getHumanoidType() {
        return humanoidType;
    }

    public void setHumanoidType(String humanoidType) {
        this.humanoidType = humanoidType;
    }
}
