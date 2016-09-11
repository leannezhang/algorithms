/**
 * Created by liyangzhang on 2016-08-05.
 */
function processData(input) {
    //Enter your code here
    var luckyNumber = 0;
    var inputNum = parseInt(input);

    if (inputNum === 1) {
        return inputNum;
    }
    for (var i=1; i<=inputNum; i++) {
        var index = i;
        var incrementNumber = luckyNumber +1;
        while (!isLuckyNum(incrementNumber.toString())) {
            incrementNumber = incrementNumber+1;
        }
        luckyNumber = incrementNumber;
    }
    return luckyNumber;

}

function isLuckyNum(input) {
    if (input.indexOf(4) === -1 && input.indexOf(13) === -1) {
        return true;
    }
    return false;
}

console.log('result: ' + processData('13'));
//process.stdin.resume();
//process.stdin.setEncoding("ascii");
//_input = "";
//process.stdin.on("data", function (input) {
//    _input += input;
//});
//
//process.stdin.on("end", function () {
//    processData(_input);
//});
