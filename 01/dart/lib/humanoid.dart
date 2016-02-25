class Humanoid {
  String humanoidType;

  void walk() {
    if (humanoidType == "Lady with high heels") {
      print("TOC! TOC! TOC!");
    } else {
      if (humanoidType == "Ninja") {
        print("...");
      } else {
        if (humanoidType == "Pirate") {
          print("Tap, toc, tap, toc.");
        } else {
          if (humanoidType == "Robot") {
            print("Bzz, bang, bzzz, bang");
          } else {
            if (humanoidType == "Regular human") {
              print("Tap, tap, tap, tap");
            }
          }
        }
      }
    }
  }
}
