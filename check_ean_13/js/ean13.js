/* Checks EAN-13 check digit */
/* Example:
checkean("5449000096241")
Returns: true/false
*/
function checkean(code)
{
	var checkdigit = 0;
	var sum = 0;
	var digit = 0;
	var act_checkdigit = parseInt(code.substring(code.length-1));
	var code = code.substring(0, 12);

	for (var i = (code.length); i > 0; i--) {
		digit = parseInt(code.substring(i, i-1));
		i%2 != 1 ? sum += (digit*3) : sum += (digit*1);
	}
	checkdigit = 10 - (sum%10);

	if (checkdigit == 10) {
		checkdigit = 0;
	}

	if (checkdigit == act_checkdigit) {
		return true;
	}
	return false;
}
