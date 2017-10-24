/* Convert yards to meters where 1 yard equals ~0.9144 (or 36/39.370113 to be more precise) meters */

function convertYardsToMeters(yards) {
  if (typeof yards != "number")
    throw new Error("Invalid Type");
  return yards * 36 / 39.370113;
}

console.log(convertYardsToMeters(1));