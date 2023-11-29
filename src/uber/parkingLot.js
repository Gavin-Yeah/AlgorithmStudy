/*
This time you are an Uber driver and you are trying your best to park your car in a parking lot.

Your car has length carDimensions[0] and width carDimensions[1]. You have already picked your lucky spot 
(rectangle of the same size as the car with upper left corner at (luckySpot[0], luckySpot[1])) and bottom right 
corner at (luckySpot[2], luckySpot[3]) and you need to find out if it's possible to park there or not.

It is possible to park your car at a given spot if and only if you can drive through the parking lot without 
any turns to your lucky spot (for safety reasons, the car can only move in two directions inside the parking lot 
    - forwards or backwards along the long side of the car) starting from some side of the lot (all four sides are valid options).

Naturally, you can't park your car if the lucky spot is already occupied. The car can't drive through or park 
at any of the occupied spots.

For carDimensions = [3, 2],

parkingLot = [[1, 0, 1, 0, 1, 0],
              [0, 0, 0, 0, 1, 0],
              [0, 0, 0, 0, 0, 1],
              [1, 0, 1, 1, 1, 1]]
and luckySpot = [1, 1, 2, 3], the output should be
parkingSpot(carDimensions, parkingLot, luckySpot) = true.
*/

function parkingSpot(carDimensions, parkingLot, luckySpot) {
    const x1 = luckySpot[0], y1 = luckySpot[1], x2 = luckySpot[2], y2 = luckySpot[3];
    if(isOccupied([x1,y1], [x2,y2], parkingLot)){
        return false;
    }
    const length = x2 - x1;
    const width = y2 - y1;
    let pass = false;
    if(length >= width){
        pass =  !isOccupied([0,y1], [x1-1,y2], parkingLot) || !isOccupied([x2+1,y1], [parkingLot.length-1,y2], parkingLot);
    }
    if(length <= width){
        pass = pass || !isOccupied([x1,0], [x2,y1-1], parkingLot) || !isOccupied([x1,y1+1], [x2, parkingLot[0].length-1], parkingLot);
    }
    return pass;
}
function isOccupied(leftCorner, rightCorner, parkingLot){
    for(let i = leftCorner[0]; i <= rightCorner[0]; i++){
        for(let j = leftCorner[1]; j <= rightCorner[1]; j++){
            if(parkingLot[i][j]){
                return true;
            }
        }
    }
    return false;
}


