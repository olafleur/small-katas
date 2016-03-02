fs = require('fs');
readline = require('readline');

function StatsCalculator() {
}

StatsCalculator.getTeamsUnderAgeAverage = function () {
    var lineReader = readline.createInterface({
        input: fs.createReadStream('input.csv')
    });

    lineReader.on('line', function (line) {
        console.log(line);
    });
};

StatsCalculator.getTeamsUnderAgeAverage();