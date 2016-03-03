fs = require('fs');
readline = require('readline');

var counter = 0;
var somme = 0;
var teams = [];

function StatsCalculator() {
}

StatsCalculator.getTeamsUnderAgeAverage = function () {
    var lineReader = readline.createInterface({
        input: fs.createReadStream('input.csv')
    });

    lineReader.on('line', function (line) {
        if(counter > 0) {
            var truc = line.split(",");

            var age = parseFloat(truc[2]);

            somme += age;
        }

        counter++;
    });

    lineReader.on('close', function () {
        var moyenne = somme / counter;
        counter = 0;

        var lineReader2 = readline.createInterface({
            input: fs.createReadStream('input.csv')
        });

        lineReader2.on('line', function (line) {
            if(counter > 0) {
                var truc = line.split(",");

                var age = parseFloat(truc[2]);

                if(age >= moyenne) {
                    /* do nothing */
                } else {
                    teams.push(truc[1]);
                }
            }

            counter++;
        });

        lineReader2.on('close', function() {
            console.log("Les équipes dont l'âge moyen est en dessous de la moyenne sont :");
            for(var i = 0; i < teams.length; i++) {
                console.log(teams[i]);
            }
        });
    });
};

StatsCalculator.getTeamsUnderAgeAverage();