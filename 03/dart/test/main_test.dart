import 'package:test/test.dart';
import 'dart:io';
import 'dart:async';
import 'dart:isolate';
import '../bin/main.dart' as bin;

main() {
  test('dummy test', () async {
    var result = bin.main(null);
    print(result);
    expect(result[0], 'rick : 50');
    expect(result[1], 'josh : 5');
  });
}