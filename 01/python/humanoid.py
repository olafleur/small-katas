class Humanoid:
    def __init__(self):
        self.humanoidType = None

    def walk(self):
        if self.humanoidType == "Lady with high heels":
            print("TOC! TOC! TOC!")
        elif self.humanoidType == "Ninja":
            print("...")
        elif self.humanoidType == "Pirate":
            print("Tap, toc, tap, toc.")
        elif self.humanoidType == "Robot":
            print("Bzz, bang, bzzz, bang")
        elif self.humanoidType == "Regular human":
            print("Tap, tap, tap, tap")

humanoid1 = Humanoid()
humanoid1.humanoidType = "Lady with high heels"
humanoid1.walk()

humanoid2 = Humanoid()
humanoid2.humanoidType = "Ninja"
humanoid2.walk()

humanoid3 = Humanoid()
humanoid3.humanoidType = "Pirate"
humanoid3.walk()

humanoid4 = Humanoid()
humanoid4.humanoidType = "Robot"
humanoid4.walk()

humanoid5 = Humanoid()
humanoid5.humanoidType = "Regular human"
humanoid5.walk()