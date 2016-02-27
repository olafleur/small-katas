import 'package:test/test.dart';
import 'dart:async';
import '../bin/main.dart' as bin;

main() {
  test("Prints expected result", () {
    var stdoutContent = <String>[];
    runZoned(() => bin.main(null),
        zoneSpecification: new ZoneSpecification(
            print: (Zone self, ZoneDelegate parent, Zone zone, String line) =>
                stdoutContent.add(line)));

    expect(stdoutContent[0], 'rick : 50');
    expect(stdoutContent[1], 'josh : 5');
  });
}
