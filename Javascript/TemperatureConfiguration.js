/**
 * Created by liyangzhang on 2016-08-05.
 */

var data = {
    speed: 10,
    inputs: [
        { time: '2016-09-11 11:00', temperature: 25 },
        { time: '2016-09-11 12:00', temperature: 35 }
    ],
    endTime: '2016-09-11 12:30',
    initialTemperature: 15
};

function processData(input) {
    //Enter your code here

}

process.stdin.resume();
process.stdin.setEncoding("ascii");
_input = "";
process.stdin.on("data", function (input) {
    _input += input;
});

process.stdin.on("end", function () {
    processData(_input);
});