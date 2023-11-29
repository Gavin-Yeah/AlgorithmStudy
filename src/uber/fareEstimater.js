/*Uber is building a Fare Estimator that can tell you how much your ride will cost before you 
request it. It works by passing approximated ride distance and ride time through this formula:

(Cost per minute) * (ride time) + (Cost per mile) * (ride distance)

where Cost per minute and Cost per mile depend on the car type.

You are one of the engineers building the Fare Estimator, so knowing cost per minute and cost 
per mile for each car type, as well as ride distance and ride time, return the fare estimates 
for all car types. */
function fareEstimator(ride_time, ride_distance, cost_per_minute, cost_per_mile) {
    const res = [];
for(let i = 0; i < cost_per_mile.length; i++){
    res[i] = ride_time * cost_per_minute[i] + ride_distance * cost_per_mile[i];
}
return res;
}
