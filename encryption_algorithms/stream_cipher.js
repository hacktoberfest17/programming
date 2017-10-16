if (!process.argv[2]) console.log("Usage: node stream_cipher <key> <plaintext/ciphertext> <-h> \n Option -h means ciphertext is in hex");
let password = Buffer(process.argv[2]);
let enc = process.argv[4] == "-h" ? "hex": "";
let enc2 = process.argv[4] != "-h" ? "hex": "";
let text = Buffer(process.argv[3], enc);

// Demo weak PRNG (its park-miller)
function* prng (seed) {
	while(true) {
		seed = seed * 16807 % 2147483647;
		yield seed % 256;
	}
}

let rand = prng( password.reduce((a,b,c) => a+b*c) );
let final = text.map(value => {
	return rand.next().value ^  value;
});

console.log(final.toString(enc2));
