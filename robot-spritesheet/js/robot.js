// @author Paul Hosler
// @date 2016
// @desc simple sprite sheet example 

(function () {
var roboA = ['-4px', '-47px', '-90px', '-148px', '-199px','-148px','-90px','-47px'];
var roboB = ['3px', '-51px', '-96px', '-145px', '-198px', '-250px', '-303px'];
var roboC = ['0px', '-50px', '-95px', '-141px', '-190px', '-238px', '-292px','-340px'];
var roboD = ['10px', '-50px', '-105px', '-165px', '-235px', '-320px','-235px','-165px','-105px','-50px'];
var roboE = ['-15px', '-65px', '-140px', '-190px', '-237px', '-290px'];
var roboF = ['20px', '-48px', '-120px', '-200px', '-290px','-200px','-120px','-48px'];
var roboG = ['-1px', '-55px', '-108px', '-167px', '-233px','-167px','-233px','-167px','-233px','-167px', '-295px','-295px','-108px','-55px'];
var roboH = ['7px', '-50px', '-109px', '-185px','-185px', '-245px', '-295px'];
var roboI = ['0px', '-52px', '-98px', '-139px', '-190px', '-239px','-239px', '-290px','-339px','-384px','-52px'];
var roboJ = ['0px', '-50px', '-99px', '-153px', '-208px', '-265px', '-322px','-390px','-445px','-445px'];
var roboK = ['0px', '-50px', '-98px', '-155px', '-211px', '-270px', '-330px','-330px'];

// cache the DOM elements
var doc = document;
var ela= doc.getElementById("robotoA");
var elb = doc.getElementById("robotoB");
var elc= doc.getElementById("robotoC");
var eld= doc.getElementById("robotoD");
var ele= doc.getElementById("robotoE");
var elf= doc.getElementById("robotoF");
var elg= doc.getElementById("robotoG");
var elh= doc.getElementById("robotoH");
var eli= doc.getElementById("robotoI");
var elj= doc.getElementById("robotoJ");
var elk= doc.getElementById("robotoK");

// these are used to iterate through the robot arrays
var a,b,c,d,e,f,g,h,i,j,k = 0;

// interval to repeat loop to simulate movement
setInterval(function() {
  (a < 7) ? ++a : a=0;
  (b < 6) ? ++b: b = 0;
  (c < 7) ? ++c : c = 0;
  (d < 9) ? ++d : d = 0;
  (e < 5) ? ++e : e = 0;
  (f < 7) ? ++f : f = 0;
  (g < 12) ? ++g : g = 0;
  (h < 6) ? ++h : h =0;
  (i < 10) ? ++i : i = 0;
  (j < 9) ? ++j : j=0;
  (k < 7) ? ++k : k = 0;

  ela.style.backgroundPosition = roboA[a] + ' 0px';
  elb.style.backgroundPosition = roboB[b] + ' -100px';
  elc.style.backgroundPosition = roboC[c] + ' -204px';
  eld.style.backgroundPosition = roboD[d] + ' -295px';
  ele.style.backgroundPosition = roboE[e] + ' -380px';
  elf.style.backgroundPosition = roboF[f] + ' -470px';
  elg.style.backgroundPosition = roboG[g] + ' -565px';
  elh.style.backgroundPosition = roboH[h] + ' -664px';
  eli.style.backgroundPosition = roboI[i] + ' -763px';
  elj.style.backgroundPosition = roboJ[j] + ' -855px';
  elk.style.backgroundPosition = roboK[k] + ' -970px';
}, 180);
})()
