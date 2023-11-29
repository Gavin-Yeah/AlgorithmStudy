/*
Consider a city where the streets are perfectly laid out to form an infinite square grid. 
In this city finding the shortest path between two given points (an origin and a destination) is much easier than 
in other more complex cities. As a new Uber developer, you are tasked to create an algorithm that does this calculation.

Given user's departure and destination coordinates, each of them located on some street, find the length of the 
shortest route between them assuming that cars can only move along the streets. Each street can be represented as 
a straight line defined by the x = n or y = n formula, where n is an integer.

Example

For departure = [0.4, 1] and destination = [0.9, 3], the output should be
perfectCity(departure, destination) = 2.7.

0.6 + 2 + 0.1 = 2.7, which is the answer. */

function perfectCity(departure, destination) {
    const x1 = departure[0], x2 = destination[0];
    const y1 = departure[1], y2 = destination[1];
    let xdis = 0;
    let ydis = 0;
    if(Math.ceil(x1) === Math.ceil(x2)){
        const ceil = Math.ceil(x1);
        xdis = Math.min(ceil - x1 + ceil - x2, x1+x2- (ceil- 1) - (ceil -1));
    } else{
        xdis = Math.abs(x1 - x2);
    }
    if(Math.ceil(y2)===Math.ceil(y1)){
        const ceil = Math.ceil(y1);
        ydis = Math.min(ceil - y1 + ceil - y2, y1 -(ceil -1) + y2 - (ceil -1));
    } else{
        ydis = Math.abs(y1 - y2);
    }
    return xdis + ydis;
}