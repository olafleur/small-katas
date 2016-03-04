fs = require('fs');
readline = require('readline');

var s1 = "";
var s2 = "";
var counter = 0;
var isReadingName = true;
var isReadingAmount = false;
var vips = [];

var lineReader = readline.createInterface({
    input: fs.createReadStream('payments.dat')
});

lineReader.on('line', function (line) {
    if (counter > 0) {
        s2 = line
    } else {
        s1 = line
    }
    counter++;
});

var currentName = "";
var currentAmount = "";
var initialMap = {};
var dueMap = {};

lineReader.on('close', function () {
    vips.push("rick");
    vips.push("matthew");

    for(var i = 0; i < s1.length; i++) {
        if(isReadingName === true) {
            if(s1[i] === ':') {
                // Name is read
                isReadingName = false;
                isReadingAmount = true;
            } else {
                currentName = currentName + s1[i];
            }
        } else if (isReadingAmount === true) {
            if(s1[i] === '|') {
                // Amount read
                isReadingName = true;
                isReadingAmount = false;
                initialMap[currentName] = parseInt(currentAmount);
                dueMap[currentName] = parseInt(currentAmount);
                currentName = "";
                currentAmount = "";
            } else {
                currentAmount = currentAmount + s1[i];
            }
        }
    }

    for(var j = 0; j < s2.length; j++) {
        if(isReadingName === true) {
            if(s2[j] === ':') {
                // Amount is read
                isReadingName = false;
                isReadingAmount = true;
            } else {
                currentName = currentName + s2[j];
            }
        } else if (isReadingAmount === true) {
            if(s2[j] === '|') {
                // Name read
                isReadingName = true;
                isReadingAmount = false;
                dueMap[currentName] = dueMap[currentName] - parseInt(currentAmount);
                currentName = "";
                currentAmount = "";
            } else {
                currentAmount = currentAmount + s2[j];
            }
        }
    }

    var dueMap2 = JSON.parse(JSON.stringify(dueMap));

    for(var name in dueMap2) {
        var due = dueMap[name];
        // VIPs be VIPs :)
        if (due === 0 || (name in dueMap && due * 100 / initialMap[name] <= 10)) {
            delete dueMap[name];
        }
    }

    for (var s in dueMap) {
        console.log(s + " : " + dueMap[s]);
    }
});

