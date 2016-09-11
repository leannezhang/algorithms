/**
 * Created by liyangzhang on 2016-08-05.
 */


//var data = {
//    p1: { start: [0,0], path: 'RUDURURU' },
//    p2: { start: [4,4], path: 'LDUDLDLD' }
//};
//
//findMeetingPoint(data);

function findMeetingPoint(data) {
    var currentP1 = {};
    currentP1.x = data.p1.start[0];
    currentP1.y = data.p1.start[1];
    currentP1.km = 0;
    var p1_path = data.p1.path;

    var currentP2 = {};
    currentP2.x = data.p2.start[0];
    currentP2.y = data.p2.start[1];
    currentP2.km = 0;
    var p2_path = data.p2.path;


    var meetingPointFound = currentP1.x === currentP2.x &&  currentP1.y ===  currentP2.y ? true : false;
    if (meetingPointFound) {
        return currentP1;
    }

    // Assume that both persons have the same path length
    var i = 0;
    while (!meetingPointFound && i < p1_path.length) {
        // go through the object p1 and p2
        var p1_dir = p1_path[i];
        currentP1 = calculateDistance(currentP1, p1_dir);

        var p2_dir = p2_path[i];
        currentP2 = calculateDistance(currentP2, p2_dir);

        meetingPointFound = currentP1.x === currentP2.x &&  currentP1.y ===  currentP2.y ? true : false;
        i++;
    }
    return currentP1;
}

function calculateDistance(currentPos, dir) {

    if (dir === 'U') {
        currentPos.y++;
    } else if (dir === 'D') {
        currentPos.y--;
    } else if (dir === 'L') {
        currentPos.x--;
    } else {
        currentPos.x++;
    }

    currentPos.km++;

    return currentPos;
}


function processData(input) {
    var json = JSON.parse(input);

    var result = findMeetingPoint(json);
    console.log(result.x + "," + result.y + " " + result.km);
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