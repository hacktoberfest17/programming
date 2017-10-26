var n;
var f = [];

f[0] = 0;
f[1] = 1;
for(i=2; i<=10; i++)
{
    f[i] = f[i-2] + f[i-1];
    console.log(f[i]);
}
