import 'package:dart/humanoid.dart';

main(List<String> args) {
  var humanoid1 = new Humanoid();
  humanoid1.humanoidType = "Lady with high heels";
  humanoid1.walk();

  var humanoid2 = new Humanoid();
  humanoid2.humanoidType = "Ninja";
  humanoid2.walk();

  var humanoid3 = new Humanoid();
  humanoid3.humanoidType = "Pirate";
  humanoid3.walk();

  var humanoid4 = new Humanoid();
  humanoid4.humanoidType = "Robot";
  humanoid4.walk();

  var humanoid5 = new Humanoid();
  humanoid5.humanoidType = "Regular human";
  humanoid5.walk();
}
