/**
 * Created by liyangzhang on 2016-08-06.
 */
function processData(input) {

    var increment = 0;
    inputNum = parseInt(input);
    for (var i = 1; i <= inputNum; i++) {
        var n = i.toString();
        var poop;
        if (n.includes('4') || n.includes('13')) {
            increment++;
        }
        poop = increment + inputNum;
        while (poop.toString().includes('4') || poop.toString().includes('13')) {
            increment++;
            poop = increment + inputNum;
        }
    }
    console.log(increment + inputNum);
}
processData('13');