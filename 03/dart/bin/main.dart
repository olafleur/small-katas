import 'dart:io';

main(List<String> args) {
  var path = 'payments.dat';
  var s1 = new File(path).readAsLinesSync()[0];
  var s2 = new File(path).readAsLinesSync()[1];

  var isReadingName = true, isReadingAmount = false;

  var vips = <String>[];
  vips.add('rick');
  vips.add('matthew');

  var initialMap = <String, int>{};
  var dueMap = <String, int>{};
  var currentName = '';
  var currentAmount = '';
  for (int charCode in s1.codeUnits) {
    var c = new String.fromCharCode(charCode);
    if (isReadingName == true) {
      if (c == ':') {
        // Name is read
        isReadingName = false;
        isReadingAmount = true;
      } else {
        currentName = currentName + c;
      }
    } else if (isReadingAmount == true) {
      if (c == '|') {
        // Amount is read
        isReadingName = true;
        isReadingAmount = false;
        initialMap[currentName] = int.parse(currentAmount);
        dueMap[currentName] = int.parse(currentAmount);
        currentName = '';
        currentAmount = '';
      } else {
        currentAmount = currentAmount + c;
      }
    }
  }

  for (int charCode in s2.codeUnits) {
    var c = new String.fromCharCode(charCode);
    if (isReadingName == true) {
      if (c == ':') {
        // Amount is read
        isReadingName = false;
        isReadingAmount = true;
      } else {
        currentName = currentName + c;
      }
    } else if (isReadingAmount == true) {
      if (c == '|') {
        // Name read
        isReadingName = true;
        isReadingAmount = false;
        dueMap[currentName] = dueMap[currentName] - int.parse(currentAmount);
        currentName = "";
        currentAmount = "";
      } else {
        currentAmount = currentAmount + c;
      }
    }
  }

  var i = dueMap.keys.iterator;
  var toRemove = <String>[];
  while (i.moveNext()) {
    var name = i.current;
    var due = dueMap[name];

    // VIPs be VIPS :)
    if (due == 0 ||
        (vips.where((String x) => x == name).isNotEmpty &&
            due * 100 / initialMap[name] <= 10)) {
      toRemove.add(i.current);
    }
  }

  toRemove.forEach((String s) => dueMap.remove(s));

  for (var s in dueMap.keys) {
    print('$s : ${dueMap[s]}');
  }
}
