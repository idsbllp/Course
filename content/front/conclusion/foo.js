function callTheRoll() {
    var persons = ['1', '2', '3', '4', '5'];
    var blacklist = [];

    return {
        callName: function(name) {
            // if (persons.indexOf(name) > -1) {
            if (~persons.indexOf(name)) {
                console.log('this one is here');
            } else {
                console.log('this one is not here');
                blacklist.push(name);
            }
        },
        getBlackList: function() {
            console.log(blacklist);
        }
    }
}

var myRoll = callTheRoll();

console.log(myRoll.blacklist); // undeifed

myRoll.callName('2')
myRoll.callName('9')

myRoll.getBlackList(); // ['9']


// Ajax

var xhr = new XMLHttpRequest();
var url = 'http://www.ruanyifeng.com/blog/2016/04/cors.html'

xhr.open('GET', url, true);

xhr.addEventListener('readystatechange', function() {
    // console.log(xhr.readyState);
    if (xhr.readyState === 4) {
        if (xhr.status === 200) {
            console.log(xhr.responseText);
            document.querySelector('.triangle').innerHTML = xhr.responseText;
        }
    }
});

// xhr.send();



















